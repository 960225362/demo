package com.example.demo.pojo;

import java.util.Date;

public class SysUserRole {
    private Long id;

    private Long userId;

    private Long roleId;

    private Date createdTime;

    private String createdBy;

    private Date modifiedTime;

    private String modifiedBy;

    private Short deleteFlag;

    public SysUserRole(Long id, Long userId, Long roleId, Date createdTime, String createdBy, Date modifiedTime, String modifiedBy, Short deleteFlag) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
        this.createdTime = createdTime;
        this.createdBy = createdBy;
        this.modifiedTime = modifiedTime;
        this.modifiedBy = modifiedBy;
        this.deleteFlag = deleteFlag;
    }

    public SysUserRole() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy == null ? null : modifiedBy.trim();
    }

    public Short getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}