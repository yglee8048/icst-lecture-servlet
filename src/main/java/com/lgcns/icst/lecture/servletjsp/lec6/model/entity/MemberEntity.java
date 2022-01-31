package com.lgcns.icst.lecture.servletjsp.lec6.model.entity;

public class MemberEntity {

    private final String memberId;
    private String memberPwd;
    private String memberName;

    public MemberEntity(String memberId, String memberPwd, String memberName) {
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
}
