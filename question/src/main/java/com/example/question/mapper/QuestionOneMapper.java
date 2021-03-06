package com.example.question.mapper;

import com.example.question.entity.QuestionOne;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionOneMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_one
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_one
     *
     * @mbggenerated
     */
    int insert(QuestionOne record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_one
     *
     * @mbggenerated
     */
    int insertSelective(QuestionOne record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_one
     *
     * @mbggenerated
     */
    QuestionOne selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_one
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(QuestionOne record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question_one
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(QuestionOne record);

    List<QuestionOne> getAll();

    List<QuestionOne> queryQuestionOneByYear(@Param ( "year" ) String year);
}