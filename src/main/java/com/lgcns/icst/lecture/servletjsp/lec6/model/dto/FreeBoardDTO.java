package com.lgcns.icst.lecture.servletjsp.lec6.model.dto;

import com.lgcns.icst.lecture.servletjsp.lec6.model.entity.FreeBoardEntity;

import java.sql.Date;

public class FreeBoardDTO {

    private Integer bNum;
    private String content;
    private Date writeDate;
    private String mid;

    public FreeBoardDTO(FreeBoardEntity freeBoardEntity) {
        this.bNum = freeBoardEntity.getBNum();
        this.content = freeBoardEntity.getContent();
        this.writeDate = freeBoardEntity.getWriteDate();
        this.mid = freeBoardEntity.getMid();
    }

    public Integer getBNum() {
        return bNum;
    }

    public String getContent() {
        return content;
    }

    public Date getWriteDate() {
        return writeDate;
    }

    public String getMid() {
        return mid;
    }
}
