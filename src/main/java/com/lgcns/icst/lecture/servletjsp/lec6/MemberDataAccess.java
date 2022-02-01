package com.lgcns.icst.lecture.servletjsp.lec6;

import com.lgcns.icst.lecture.servletjsp.lec5.MemberEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDataAccess {

    public MemberEntity findMemberByIdAndPassword(String memberId, String memberPw) {
        final String DRIVER = "oracle.jdbc.OracleDriver";
        final String URL = "jdbc:oracle:thin:@10.100.70.7:1521:XE";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // JDBC Driver 로딩
            Class.forName(DRIVER);
            // Connection 획득 (본인의 아이디와 비밀번호 사용)
            connection = DriverManager.getConnection(URL, "student#", "student#");

            String sql = "SELECT MEMBER_NAME FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberId);
            preparedStatement.setString(2, memberPw);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String memberName = resultSet.getString("MEMBER_NAME");
                return new MemberEntity(memberId, memberPw, memberName);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 생성한 역순으로 반환(close)한다.
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
