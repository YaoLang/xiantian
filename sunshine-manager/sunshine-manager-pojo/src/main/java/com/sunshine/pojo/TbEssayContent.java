package com.sunshine.pojo;

import java.util.Date;

public class TbEssayContent {
    private String essayid;

    private Date created;

    private Date updated;

    private String contentDesc;

    public String getessayid() {
        return essayid;
    }

    public void setessayid(String essayid) {
        this.essayid = essayid == null ? null : essayid.trim();
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

    public String getContentDesc() {
        return contentDesc;
    }

    public void setContentDesc(String contentDesc) {
        this.contentDesc = contentDesc == null ? null : contentDesc.trim();
    }
}