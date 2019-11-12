package com.example.question.service.impl;

import com.example.question.common.DataListResponse;
import com.example.question.common.ResponseCode;
import com.example.question.entity.QuestionOne;
import com.example.question.mapper.QuestionOneMapper;
import com.example.question.service.QuestionOneService;
import com.example.question.vo.QuestionOneVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("questionOneService")
public class QuestionOneServiceImpl implements QuestionOneService {

    @Autowired
    private QuestionOneMapper questionOneMapper;

    @Override
    public DataListResponse<QuestionOne> getAll() {
        List <QuestionOne> all = questionOneMapper.getAll ();
        DataListResponse<QuestionOne> response = new DataListResponse <> ( ResponseCode.SUCCESS,all );
        return response;
    }

    @Override
    public DataListResponse <QuestionOne> queryQuestionOneByYear(String year) {
        List <QuestionOne> all = questionOneMapper.queryQuestionOneByYear (year);
        DataListResponse<QuestionOne> response = new DataListResponse <> ( ResponseCode.SUCCESS,all );
        return response;
    }

    @Override
    public DataListResponse <QuestionOne> update(QuestionOneVo questionOneVo) {
        QuestionOne questionOne = new QuestionOne ();
        System.out.println (questionOneVo.getYear ());
        questionOne.setId ( questionOneVo.getId () );
        questionOne.setYear (questionOneVo.getYear ());
        questionOneMapper.updateByPrimaryKeySelective ( questionOne);
        return getAll ();
    }
}
