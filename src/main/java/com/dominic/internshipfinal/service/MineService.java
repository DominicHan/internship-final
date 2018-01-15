package com.dominic.internshipfinal.service;

import com.dominic.internshipfinal.domain.MineInfo;
import com.dominic.internshipfinal.domain.entity.Mine;
import com.dominic.internshipfinal.domain.entity.MineComments;
import com.dominic.internshipfinal.domain.entity.MinePraise;

import java.util.List;

public interface MineService {
    // 给消息点赞
    void setPraise(int mineInfoId, String account);
    // 给消息评论
    void setComments(int mineInfoId, String account, String content);
    // 根据消息id获取消息信息
    Mine getMineById(int id);
    // 获取所有消息(包括赞的信息和评论信息)
    List<Mine> mineMapper();
    // 获取给消息点赞的昵称
    List<MinePraise> getPraise(int id);
    // 获取给消息的评论数据
    List<MineComments> getComments(int id);
    // 根据账号获取昵称
    String getNick(String account);
    // 查看该账号是否已经点赞该消息
    MinePraise checkPraise(MinePraise minePraise);
}
