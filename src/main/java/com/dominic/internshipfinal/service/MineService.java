package com.dominic.internshipfinal.service;

import com.dominic.internshipfinal.domain.MineInfo;

import java.util.List;

public interface MineService {
    // 给消息点赞
    void setPraise(int mineInfoId, String account);
    // 给消息评论
    void setComments(int mineInfoId, String account, String content);
    // 根据消息id获取消息信息
    MineInfo getMineInfoById(int id);
    // 获取所有消息(包括赞的信息和评论信息)
    List<MineInfo> getMineInfo();
}
