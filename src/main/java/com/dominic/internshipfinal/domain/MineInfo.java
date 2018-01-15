package com.dominic.internshipfinal.domain;

import com.dominic.internshipfinal.domain.entity.Mine;
import com.dominic.internshipfinal.domain.entity.MineComments;

import java.util.List;

public class MineInfo {

    private Mine mine;                 //消息主体数据
    private List<String> minePraiseList;   // 点过赞的昵称
    private List<MineCommentsInfo> mineComments; // 评论
    private List<String> picList;  // 图片组
    private int isPraise;          // 此条信息是否点过赞

    public int getIsPraise() {
        return isPraise;
    }

    public void setIsPraise(int isPraise) {
        this.isPraise = isPraise;
    }

    public MineInfo() {}

    public MineInfo(Mine mine, List<String> minePraiseList, List<MineCommentsInfo> mineComments, List<String> picList, int isPraise) {
        this.mine = mine;
        this.minePraiseList = minePraiseList;
        this.mineComments = mineComments;
        this.picList = picList;
        this.isPraise = isPraise;
    }

    public MineInfo(Mine mine, List<String> minePraiseList, List<MineCommentsInfo> mineComments, List<String> picList) {
        this.mine = mine;
        this.minePraiseList = minePraiseList;
        this.mineComments = mineComments;
        this.picList = picList;
    }

    public Mine getMine() {
        return mine;
    }

    public void setMine(Mine mine) {
        this.mine = mine;
    }

    public List<String> getMinePraiseList() {
        return minePraiseList;
    }

    public void setMinePraiseList(List<String> minePraiseList) {
        this.minePraiseList = minePraiseList;
    }

    public List<MineCommentsInfo> getMineComments() {
        return mineComments;
    }

    public void setMineComments(List<MineCommentsInfo> mineComments) {
        this.mineComments = mineComments;
    }

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }
}
