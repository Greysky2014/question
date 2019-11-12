package com.example.question.controller;

import com.example.question.common.DataListResponse;
import com.example.question.entity.QuestionOne;
import com.example.question.service.QuestionOneService;
import com.example.question.vo.QuestionOneVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("questionOne")
public class QuestionOneController {

    @Autowired
    private QuestionOneService questionOneService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public DataListResponse<QuestionOne> getAll(){
        return questionOneService.getAll ();
    }

    @RequestMapping(value = "{year}",method = RequestMethod.GET)
    public DataListResponse<QuestionOne> queryQuestionOneByYear(@PathVariable("year") String year){
        return questionOneService.queryQuestionOneByYear (year);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public DataListResponse<QuestionOne> update(@RequestBody QuestionOneVo questionOneVo){
        DataListResponse<QuestionOne> response = questionOneService.update(questionOneVo);
        return response;
    }
}
