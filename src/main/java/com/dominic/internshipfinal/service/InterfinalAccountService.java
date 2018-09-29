package com.dominic.internshipfinal.service;


import com.dominic.internshipfinal.domain.entity.InterfinalAccount;

import java.util.List;


public interface InterfinalAccountService {
    InterfinalAccount getAccount(int id);
    InterfinalAccount getAccountByAccountNo(String account);
    int addAccount(InterfinalAccount account);
    void setGestures(InterfinalAccount account);
    List<InterfinalAccount> getUserList();
}
