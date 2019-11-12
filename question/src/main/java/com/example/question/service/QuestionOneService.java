package com.example.question.service;

import com.example.question.common.DataListResponse;
import com.example.question.entity.QuestionOne;
import com.example.question.vo.QuestionOneVo;

public interface QuestionOneService {

    public DataListResponse<QuestionOne> getAll();

    DataListResponse<QuestionOne> queryQuestionOneByYear(String year);

    DataListResponse<QuestionOne> update(QuestionOneVo questionOneVo);
}
