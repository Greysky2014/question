package com.example.question.common;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExportCommon {

    //导出到浏览器，BasicParams 是打印模板的基础类，自己创建的，包括文件的类型和模板的路径等
    public void exportBrowser(HttpServletResponse response, Map<String, Object> map, BasicParams basicParams, List<?> data) throws Exception{
        ServletOutputStream sosRef = null;
        InputStream isRef = null;
        List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint> ();
        try {
            isRef = this.getClass().getResourceAsStream(basicParams.getTemplatePath());
            JasperPrint report = JasperFillManager.fillReport(isRef, map, new JRBeanCollectionDataSource (data));
            JRAbstractExporter exporter = null;
            sosRef = response.getOutputStream();
            response.setContentType("application/octet-stream");// 二进制流，不知道下载文件的类型
            response.setHeader("content-type", "application/octet-stream");// 让服务器告诉浏览器它发送的数据属于什么文件类型
            //FileType.PDF是文件的枚举类型，也是自己创建的
            if(basicParams.getFileType() == FileType.PDF) {
                response.setHeader("Content-Disposition", "attachment;fileName=" + new String((basicParams.getFileName().toString()+".pdf").getBytes(),"ISO8859-1"));// 设置文件名（这个信息头会告诉浏览器这个文件的名字和类型）
            }
            if(basicParams.getFileType() == FileType.EXCEL) {
                response.setHeader("Content-Disposition", "attachment;fileName=" + new String((basicParams.getFileName()+".xlsx").getBytes(),"ISO8859-1"));
            }
            if(basicParams.getFileType() == FileType.WORD) {
                response.setHeader("Content-Disposition", "attachment;fileName=" + new String((basicParams.getFileName().toString()+".docx").getBytes(),"ISO8859-1"));
            }
            exporter = createExporter(basicParams.getFileType(),report,sosRef);

        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw e;
        }finally {
            sosRef.close();
            isRef.close();
        }
    }


    //对应导出不同类型文件的配置
    private JRAbstractExporter createExporter(FileType fileType,JasperPrint jasperPrint,OutputStream sosRefFile)
    {
        JRAbstractExporter result = null;
        try {
            if (fileType == FileType.PDF) {
                result = new JRPdfExporter ();
                result.setExporterInput(new SimpleExporterInput (jasperPrint));
                result.setExporterOutput(new SimpleOutputStreamExporterOutput (sosRefFile));
                SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration ();
                result.setConfiguration(configuration);
                result.exportReport();
            }
            if (fileType == FileType.EXCEL) {
                result = new JRXlsxExporter ();
                result.setExporterInput(new SimpleExporterInput(jasperPrint));
                result.setExporterOutput(new SimpleOutputStreamExporterOutput(sosRefFile));
                SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
                configuration.setOnePagePerSheet(true);
                configuration.setDetectCellType(true);
                configuration.setCollapseRowSpan(false);
                result.setConfiguration(configuration);
                result.exportReport();
            }
            if (fileType == FileType.WORD) {
                result = new JRDocxExporter ();
                result.setExporterInput(new SimpleExporterInput(jasperPrint));
                result.setExporterOutput(new SimpleOutputStreamExporterOutput(sosRefFile));
                SimpleDocxExporterConfiguration configuration = new SimpleDocxExporterConfiguration();
                result.setConfiguration(configuration);
                result.exportReport();
            }
        }catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

}
