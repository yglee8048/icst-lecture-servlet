package com.lgcns.icst.lecture.servletjsp.lec6.model.dto;

import com.lgcns.icst.lecture.servletjsp.lec6.model.entity.MemberEntity;

public class MemberDTO {

    private String memberId;
    private String memberPwd;
    private String memberName;

    public MemberDTO(String memberId, String memberPwd, String memberName) {
        this.memberId = memberId;
        this.memberPwd = memberPwd;
        this.memberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberPwd() {
        return memberPwd;
    }

    public String getMemberName() {
        return memberName;
    }

    public MemberEntity toEntity() {
        return new MemberEntity(memberId, memberPwd, memberName);
    }
}
