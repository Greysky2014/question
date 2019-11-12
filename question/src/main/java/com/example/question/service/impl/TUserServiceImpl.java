package com.example.question.service.impl;

import com.example.question.entity.TUser;
import com.example.question.mapper.TUserMapper;
import com.example.question.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tUserService")
public class TUserServiceImpl implements TUserService {

    @Autowired
    private TUserMapper tUserMapper;

    @Override
    public List<TUser> getAll() {
        return tUserMapper.getAll ();
    }
}
