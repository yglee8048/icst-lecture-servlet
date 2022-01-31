package com.lgcns.icst.lecture.servletjsp.lec4;

public class MemberEntity {

    private String memberId;
    private String memberPw;
    private String memberName;

    public MemberEntity(String memberId, String memberPw, String memberName) {
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
}
