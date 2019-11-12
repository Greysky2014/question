package com.example.question.service.impl;

import com.example.question.common.Caculate;
import com.example.question.common.DataResponse;
import com.example.question.common.ResponseCode;
import com.example.question.service.CalculationService;
import com.example.question.vo.CalculationVo;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @project: question
 * @description:
 * @author: Mr.Wang
 * @create: 2019-11-09 08:05
 * @modify:
 * @version: v1.0
 **/
@Service("calculationService")
public class CalculationServiceImpl implements CalculationService {

    @Override
    public DataResponse<Integer> calculation(CalculationVo calculationVo) {
        DataResponse<Integer> response;
        System.out.println(Arrays.toString(calculationVo.getParams()));
        System.out.println(Arrays.toString(calculationVo.getParamValues()));
        String[] params = calculationVo.getParams();
        String[] paramsValues = calculationVo.getParamValues();
        for (String str : paramsValues) {
            try {
                Integer.parseInt(str);
            }catch (NumberFormatException e){
                response = new DataResponse<>(ResponseCode.PARAM_ERROR,0);
                return response;
            }
        }
        StringBuilder stringBuffer = new StringBuilder();
        //替换内容
        if (calculationVo.isStatus()){
            stringBuffer = new StringBuilder(calculationVo.getFirstParam()[0]);
        }
        for (int i = 0; i < params.length; i++) {
            String s = params[i].replaceAll("\\s+", "").replaceAll("[{]\\S{2}\\d+[}]", paramsValues[i]);
            System.out.println(s);
            stringBuffer.append(s);
        }
        System.out.println(stringBuffer.toString());
        String result = Caculate.calFinalResult(stringBuffer.toString());
        System.out.println(result);
        try {
            response = new DataResponse<>(ResponseCode.SUCCESS,Integer.parseInt(result));
        }catch (NumberFormatException e){
            response = new DataResponse<>(ResponseCode.FAIL,0);
        }

        return response;
    }
}
