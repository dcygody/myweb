package com.springboot.service.impl;

import com.springboot.Model.Administrator;
import com.springboot.mapper.AdminMapper;
import com.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminImpl implements AdminService{

    @Autowired
    AdminMapper adminMapper;
    @Override
    public List<Administrator> getAll() {
        return adminMapper.getAll();
    }
}
