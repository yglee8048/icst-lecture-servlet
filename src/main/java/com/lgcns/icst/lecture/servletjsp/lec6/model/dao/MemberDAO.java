package com.lgcns.icst.lecture.servletjsp.lec6.model.dao;

import com.lgcns.icst.lecture.servletjsp.lec6.model.entity.MemberEntity;
import com.lgcns.icst.lecture.servletjsp.lec6.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

    public MemberEntity findMemberById(Connection connection, String memberId) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            String sql = "SELECT MEMBERPWD, MEMBERNAME FROM MEMBER WHERE MEMBERID = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String memberPassword = resultSet.getString("MEMBERPWD");
                String memberName = resultSet.getString("MEMBERNAME");
                return new MemberEntity(memberId, memberPassword, memberName);
            }
        } finally {
            // 생성한 역순으로 반환(close)한다.
            JdbcUtil.close(resultSet);
            JdbcUtil.close(preparedStatement);
        }
        return null;
    }

    public boolean saveMember(Connection connection, MemberEntity memberEntity) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO MEMBER(MEMBERID, MEMBERPWD, MEMBERNAME) VALUES(?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberEntity.getMemberId());
            preparedStatement.setString(2, memberEntity.getMemberPwd());
            preparedStatement.setString(3, memberEntity.getMemberName());

            int result = preparedStatement.executeUpdate();
            return result == 1;
        } finally {
            JdbcUtil.close(preparedStatement);
        }
    }
}
