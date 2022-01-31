package com.lgcns.icst.lecture.servletjsp.lec4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectMember {

    public MemberEntity findMemberByIdAndPassword(String id, String password) {
        final String DRIVER = "oracle.jdbc.OracleDriver";
        final String URL = "jdbc:oracle:thin:@10.100.70.7:1521:XE";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // JDBC Driver 로딩
            Class.forName(DRIVER);
            // Connection 획득 (본인의 아이디와 비밀번호 사용)
            connection = DriverManager.getConnection(URL, "student#", "student#");

            // 쿼리
            String sql = "SELECT MEMBER_NAME FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PW = ?";
            // Statement 생성
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, password);

            // 쿼리 수행
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String memberName = resultSet.getString("MEMBER_NAME");

                return new MemberEntity(id, password, memberName);
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
            if (statement != null) {
                try {
                    statement.close();
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
