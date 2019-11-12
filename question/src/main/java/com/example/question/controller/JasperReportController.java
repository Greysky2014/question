package com.example.question.controller;

import com.example.question.common.BasicParams;
import com.example.question.common.ExportCommon;
import com.example.question.common.FileType;
import com.example.question.entity.Product;
import com.example.question.entity.TUser;
import com.example.question.service.ProductService;
import com.example.question.service.TUserService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Controller
public class JasperReportController {

    @Autowired
    private TUserService tUserService;


    @Autowired
    private ProductService productService;

    @RequestMapping("/originaldisplay")
    public void originaldisplay(HttpServletResponse response )throws Exception {
        //map对应模板中Parameters中的参数
        Map<String, Object> params = new HashMap<String,Object> ();
        /*params.put("applyDate",new Date (2019,1,10));
        params.put("sampleNo", "976073X");
        //子报表
        params.put("SUBPATH_TWO", this.getClass().getClassLoader().getResource("jasper")+"/table.jasper");
        params.put("tips", "无附件");*/
        //list对应模板中Fields中的参数，Displaymain中的两个list元素，一个对应table，一个对应子报表
        List<TUser> listdata = tUserService.getAll ();
        ServletOutputStream sosRefPdf = null;
        InputStream isRef = null;
        List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint> ();
        try {
            isRef = this.getClass().getResourceAsStream("/jasper/table.jasper");
            JasperPrint report = JasperFillManager.fillReport(isRef, params, new JRBeanCollectionDataSource (listdata));
            JRAbstractExporter exporter = null;
            sosRefPdf = response.getOutputStream();
            response.setHeader("Content-disposition", "inline; filename=" + new String(("表格"+".pdf").getBytes(),"ISO8859-1"));
            JasperExportManager.exportReportToPdfStream(report, sosRefPdf);
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            sosRefPdf.close();
            isRef.close();
        }
    }

    @RequestMapping("/originaldisplay/download")
    public void originaldisplayDownload(HttpServletResponse response )throws Exception {
        //map对应模板中Parameters中的参数
        Map<String, Object> params = new HashMap<String,Object> ();
        /*params.put("applyDate",new Date (2019,1,10));
        params.put("sampleNo", "976073X");
        //子报表
        params.put("SUBPATH_TWO", this.getClass().getClassLoader().getResource("jasper")+"/table.jasper");
        params.put("tips", "无附件");*/
        //list对应模板中Fields中的参数，Displaymain中的两个list元素，一个对应table，一个对应子报表
        List<TUser> listdata = tUserService.getAll ();

        ExportCommon exportCommon = new ExportCommon ();

        BasicParams basicParams = new BasicParams ();
        basicParams.setTemplatePath ( "/jasper/table.jasper" );
        basicParams.setFileName ( "二维表格" );
        basicParams.setFileType ( FileType.EXCEL );
        basicParams.setSavePath ( "" );
        exportCommon.exportBrowser ( response,params, basicParams,listdata);
        /*ServletOutputStream sosRefPdf = null;
        InputStream isRef = null;
        List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint> ();
        try {
            isRef = this.getClass().getResourceAsStream("/jasper/table.jasper");
            JasperPrint report = JasperFillManager.fillReport(isRef, params, new JRBeanCollectionDataSource (listdata));
            JRAbstractExporter exporter = null;
            sosRefPdf = response.getOutputStream();
            response.setHeader("Content-disposition", "inline; filename=" + new String(("表格"+".pdf").getBytes(),"ISO8859-1"));
            JasperExportManager.exportReportToPdfStream(report, sosRefPdf);
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            sosRefPdf.close();
            isRef.close();
        }*/
    }

    @RequestMapping("/originaldisplay/chart")
    public void originaldisplayChart(HttpServletResponse response )throws Exception {
        //map对应模板中Parameters中的参数
        Map<String, Object> params = new HashMap<String,Object> ();
        //list对应模板中Fields中的参数，Displaymain中的两个list元素，一个对应table，一个对应子报表
        List<Product> listdata = productService.getAll ();
/*        ExportCommon exportCommon = new ExportCommon ();

        BasicParams basicParams = new BasicParams ();
        basicParams.setTemplatePath ( "/jasper/chart.jasper" );
        basicParams.setFileName ( "图表" );
        basicParams.setFileType ( FileType.PDF );
        basicParams.setSavePath ( "" );
        exportCommon.exportBrowser ( response,params, basicParams,listdata);*/
        ServletOutputStream sosRefPdf = null;
        InputStream isRef = null;
        List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint> ();
        try {
            isRef = this.getClass().getResourceAsStream("/jasper/chart.jasper");
            JasperPrint report = JasperFillManager.fillReport(isRef, params, new JRBeanCollectionDataSource (listdata));
            JRAbstractExporter exporter = null;
            sosRefPdf = response.getOutputStream();
            response.setHeader("Content-disposition", "inline; filename=" + new String(("图表"+".pdf").getBytes(),"ISO8859-1"));
            JasperExportManager.exportReportToPdfStream(report, sosRefPdf);
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }catch (JRException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            sosRefPdf.close();
            isRef.close();
        }
    }
}
