package com.lgcns.icst.lecture.servletjsp.lec4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PreparedStatementSample {

    public static void main(String[] args) {
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

            // 쿼리
            String sql = "SELECT DEPT_ID, DEPT_NAME, DIVISION_ID, REGION_ID FROM TBL_DEPARTMENT WHERE DEPT_ID = ?";
            // Statement 생성
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "T01");

            // 쿼리 수행
            resultSet = preparedStatement.executeQuery();   // sql 을 넣으면 안 된다!
//            int result = preparedStatement.executeUpdate();

            while (resultSet.next()) {
                String deptId = resultSet.getString("DEPT_ID");
                System.out.println("deptId = " + deptId);
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
    }
}
