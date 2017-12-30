package com.dominic.internshipfinal.service.impl;

import com.dominic.internshipfinal.dao.InterfinalAccountMapper;
import com.dominic.internshipfinal.entity.InterfinalAccount;
import com.dominic.internshipfinal.service.InterfinalAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterfinalAccountServiceImpl implements InterfinalAccountService {

    @Autowired
    InterfinalAccountMapper interfinalAccountMapper;

    @Override
    public InterfinalAccount getAccount(int id) {
        return interfinalAccountMapper.selectByPrimaryKey(id);
    }
}
