package com.sunshine.pojo;

import java.util.Date;

public class TbNoteComment {
    private String id;

    private String content;

    private Integer zannum;

    private Integer commentnum;

    private Long auther;

    private String authername;

    private String noteid;

    private Date created;

    private Date updated;

    private Byte status;

    private String subcomment;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getZannum() {
        return zannum;
    }

    public void setZannum(Integer zannum) {
        this.zannum = zannum;
    }

    public Integer getCommentnum() {
        return commentnum;
    }

    public void setCommentnum(Integer commentnum) {
        this.commentnum = commentnum;
    }

    public Long getAuther() {
        return auther;
    }

    public void setAuther(Long auther) {
        this.auther = auther;
    }

    public String getAuthername() {
        return authername;
    }

    public void setAuthername(String authername) {
        this.authername = authername == null ? null : authername.trim();
    }

    public String getNoteid() {
        return noteid;
    }

    public void setNoteid(String noteid) {
        this.noteid = noteid == null ? null : noteid.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getSubcomment() {
        return subcomment;
    }

    public void setSubcomment(String subcomment) {
        this.subcomment = subcomment == null ? null : subcomment.trim();
    }
}