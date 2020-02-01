package com.example.demo.pojo;

import org.springframework.security.core.GrantedAuthority;

import java.util.Date;

public class SysRole implements GrantedAuthority {
    private Long id;

    private String role;

    private Date createdTime;

    private String createdBy;

    private Date modifiedTime;

    private String modifiedBy;

    private Short deleteFlag;

    public SysRole(Long id, String role, Date createdTime, String createdBy, Date modifiedTime, String modifiedBy, Short deleteFlag) {
        this.id = id;
        this.role = role;
        this.createdTime = createdTime;
        this.createdBy = createdBy;
        this.modifiedTime = modifiedTime;
        this.modifiedBy = modifiedBy;
        this.deleteFlag = deleteFlag;
    }

    public SysRole() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
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

    @Override
    public String getAuthority() {
        return role;
    }
}