package com.lgcns.icst.lecture.servletjsp.lec4;

import java.sql.Date;

public class FreeBoardEntity {

    private final Integer bNum;
    private String content;
    private Date writeDate;
    private String mid;

    public FreeBoardEntity(Integer bNum, String content, Date writeDate, String mid) {
        this.bNum = bNum;
        this.content = content;
        this.writeDate = writeDate;
        this.mid = mid;
    }

    public Integer getbNum() {
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
