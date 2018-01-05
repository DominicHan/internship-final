package com.dominic.internshipfinal.domain.entity;

import java.io.Serializable;

public class InterfinalRole implements Serializable {
    private Integer id;

    private String roleName;

    private String roleDescribe;

    private Short roleState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleDescribe() {
        return roleDescribe;
    }

    public void setRoleDescribe(String roleDescribe) {
        this.roleDescribe = roleDescribe == null ? null : roleDescribe.trim();
    }

    public Short getRoleState() {
        return roleState;
    }

    public void setRoleState(Short roleState) {
        this.roleState = roleState;
    }
}