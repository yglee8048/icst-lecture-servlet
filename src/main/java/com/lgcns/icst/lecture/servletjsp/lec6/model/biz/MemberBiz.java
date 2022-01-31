package com.lgcns.icst.lecture.servletjsp.lec6.model.biz;

import com.lgcns.icst.lecture.servletjsp.lec6.model.dao.MemberDAO;
import com.lgcns.icst.lecture.servletjsp.lec6.model.entity.MemberEntity;
import com.lgcns.icst.lecture.servletjsp.lec6.model.dto.MemberDTO;
import com.lgcns.icst.lecture.servletjsp.lec6.util.JdbcUtil;

import java.sql.Connection;

public class MemberBiz {

    public MemberDTO login(String memberId, String memberPassword) throws Exception {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();

            MemberDAO memberDAO = new MemberDAO();
            MemberEntity member = memberDAO.findMemberById(connection, memberId);

            if (member == null) {
                throw new Exception("존재하지 않는 아이디입니다.");
            } else if (!member.getMemberPw().equals(memberPassword)) {
                throw new Exception("비밀번호가 일치하지 않습니다.");
            } else {
                return new MemberDTO(memberId, memberPassword, member.getMemberName());
            }
        } finally {
            JdbcUtil.close(connection);
        }
    }

    public void signUp(MemberDTO member) throws Exception {
        Connection connection = null;
        try {
            connection = JdbcUtil.getConnection();

            MemberDAO memberDAO = new MemberDAO();
            boolean result = memberDAO.saveMember(connection, member.toEntity());
            if (result) {
                JdbcUtil.commit(connection);
            } else {
                throw new Exception("회원 가입에 실패했습니다.");
            }
        } catch (Exception e) {
            JdbcUtil.rollback(connection);
            throw e;
        } finally {
            JdbcUtil.close(connection);
        }
    }
}
