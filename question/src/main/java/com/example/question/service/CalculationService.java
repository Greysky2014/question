package com.example.question.service;

import com.example.question.common.DataResponse;
import com.example.question.vo.CalculationVo;

/**
 * @project: question
 * @description:
 * @author: Mr.Wang
 * @create: 2019-11-09 08:05
 * @modify:
 * @version: v1.0
 **/
public interface CalculationService {
    DataResponse<Integer> calculation(CalculationVo calculationVo);
}
