package com.dominic.internshipfinal.service.impl;

import com.dominic.internshipfinal.dao.InterfinalAccountMapper;
import com.dominic.internshipfinal.dao.MineCommentsMapper;
import com.dominic.internshipfinal.dao.MineMapper;
import com.dominic.internshipfinal.dao.MinePraiseMapper;
import com.dominic.internshipfinal.domain.MineInfo;
import com.dominic.internshipfinal.domain.entity.Mine;
import com.dominic.internshipfinal.domain.entity.MineComments;
import com.dominic.internshipfinal.domain.entity.MinePraise;
import com.dominic.internshipfinal.service.MineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MineServiceImpl implements MineService {

    @Autowired
    MinePraiseMapper minePraiseMapper;

    @Autowired
    MineCommentsMapper mineCommentsMapper;

    @Autowired
    MineMapper mineMapper;

    @Autowired
    InterfinalAccountMapper interfinalAccountMapper;

    @Override
    public void setPraise(int mineInfoId, String account) {
        MinePraise minePraise = new MinePraise();
        minePraise.setMineInfoId(mineInfoId);
        minePraise.setAccount(account);
        minePraise.setSubmitTime(new Date());
        minePraiseMapper.insertSelective(minePraise);
    }

    @Override
    public void deletePraise(MinePraise minePraise) {
        minePraiseMapper.deleteByIdAccount(minePraise);
    }

    @Override
    public void setComments(int mineInfoId, String account, String content) {
        MineComments mineComments = new MineComments();
        mineComments.setMineInfoId(mineInfoId);
        mineComments.setAccount(account);
        mineComments.setSubmitContent(content);
        mineComments.setSubmitTime(new Date());
        mineCommentsMapper.insertSelective(mineComments);
    }

    @Override
    public Mine getMineById(int id) {
        return mineMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Mine> mineMapper() {
        return mineMapper.selectAll();
    }

    @Override
    public List<MinePraise> getPraise(int id) {
        return minePraiseMapper.selectById(id);
    }

    @Override
    public List<MineComments> getComments(int id) {
        return mineCommentsMapper.selectById(id);
    }

    @Override
    public String getNick(String account) {
        return interfinalAccountMapper.selectByAccountNo(account).getNick();
    }

    @Override
    public MinePraise checkPraise(MinePraise minePraise) {
        return minePraiseMapper.selectByIdAccount(minePraise);
    }

}
