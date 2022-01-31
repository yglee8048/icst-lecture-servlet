package com.lgcns.icst.lecture.servletjsp.lec6.model.dto;

import com.lgcns.icst.lecture.servletjsp.lec6.model.entity.FreeBoardEntity;

import java.sql.Date;

public class FreeBoardDTO {

    private Long id;
    private String content;
    private String writerId;
    private Date writeDate;

    public FreeBoardDTO(FreeBoardEntity freeBoardEntity) {
        this.id = freeBoardEntity.getId();
        this.content = freeBoardEntity.getContent();
        this.writerId = freeBoardEntity.getWriterId();
        this.writeDate = freeBoardEntity.getWriteDate();
    }

    public Long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getWriterId() {
        return writerId;
    }

    public Date getWriteDate() {
        return writeDate;
    }
}
