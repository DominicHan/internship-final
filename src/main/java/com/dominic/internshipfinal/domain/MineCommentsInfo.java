package com.dominic.internshipfinal.domain;

public class MineCommentsInfo {
    private String nickName;
    private String content;

    public MineCommentsInfo() {}

    public MineCommentsInfo(String nickName, String content) {
        this.nickName = nickName;
        this.content = content;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
