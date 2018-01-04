package com.dominic.internshipfinal.domain;

import com.dominic.internshipfinal.domain.entity.Mine;
import com.dominic.internshipfinal.domain.entity.MineComments;
import com.dominic.internshipfinal.domain.entity.MinePraise;

import java.util.List;

public class MineInfo {
    private Mine mine;
    private List<MinePraise> minePraiseList;
    private List<MineComments> mineComments;
    private List<String> picList;

    public MineInfo() {}

    public MineInfo(Mine mine, List<MinePraise> minePraiseList, List<MineComments> mineComments, List<String> picList) {
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

    public List<MinePraise> getMinePraiseList() {
        return minePraiseList;
    }

    public void setMinePraiseList(List<MinePraise> minePraiseList) {
        this.minePraiseList = minePraiseList;
    }

    public List<MineComments> getMineComments() {
        return mineComments;
    }

    public void setMineComments(List<MineComments> mineComments) {
        this.mineComments = mineComments;
    }

    public List<String> getPicList() {
        return picList;
    }

    public void setPicList(List<String> picList) {
        this.picList = picList;
    }
}
