package com.lgcns.icst.lecture.servletjsp.lec4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDeptByPreparedStmt {

    public static void main(String[] args) {
        final String DRIVER = "oracle.jdbc.OracleDriver";
        final String URL = "jdbc:oracle:thin:@10.100.70.7:1521:XE";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // JDBC Driver 로딩
            Class.forName(DRIVER);
            // Connection 획득 (본인의 아이디와 비밀번호 사용)
            connection = DriverManager.getConnection(URL, "mission303", "mission303");

            // 쿼리
            String sql = "UPDATE TBL_DEPARTMENT SET DEPT_NAME = ? WHERE DEPT_NAME = ?";
            // PreparedStatement 생성
            statement = connection.prepareStatement(sql);
            // 동적 할당
            statement.setString(1, "앱개발팀");
            statement.setString(2, "모바일개발팀");

            // 쿼리 수행
            int result = statement.executeUpdate();
            System.out.println("result = " + result);
            if (result < 1) {
                System.out.println("fail!");
            } else {
                System.out.println("success!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        } finally {
            // 생성한 역순으로 반환(close)한다.
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
    }
}
