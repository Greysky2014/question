package com.example.question.controller;

import com.example.question.common.DataResponse;
import com.example.question.service.CalculationService;
import com.example.question.vo.CalculationVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @project: question
 * @description:
 * @author: Mr.Wang
 * @create: 2019-11-09 08:04
 * @modify:
 * @version: v1.0
 **/
@RestController
@RequestMapping("calculation")
public class CalculationController {

    @Autowired
    private CalculationService calculationService;

    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public DataResponse<Integer> result(@RequestBody CalculationVo calculationVo){
        DataResponse<Integer> result = calculationService.calculation(calculationVo);
        return result;
    }
}
