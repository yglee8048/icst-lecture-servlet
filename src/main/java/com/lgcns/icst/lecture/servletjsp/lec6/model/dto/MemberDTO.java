package com.lgcns.icst.lecture.servletjsp.lec6.model.dto;

import com.lgcns.icst.lecture.servletjsp.lec6.model.entity.MemberEntity;

public class MemberDTO {

    private String memberId;
    private String memberPw;
    private String memberName;

    public MemberDTO(String memberId, String memberPw, String memberName) {
        this.memberId = memberId;
        this.memberPw = memberPw;
        this.memberName = memberName;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getMemberPw() {
        return memberPw;
    }

    public String getMemberName() {
        return memberName;
    }

    public MemberEntity toEntity() {
        return new MemberEntity(memberId, memberPw, memberName);
    }
}
