package com.lgcns.icst.lecture.servletjsp.lec4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccessSample {

    public static void main(String[] args) {
        final String DRIVER = "oracle.jdbc.OracleDriver";
        final String URL = "jdbc:oracle:thin:@10.100.70.7:1521:XE";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // JDBC Driver 로딩
            Class.forName(DRIVER);
            // Connection 획득 (본인의 아이디와 비밀번호 사용)
            connection = DriverManager.getConnection(URL, "student#", "student#");

            // 쿼리
            String sql = "SELECT DEPT_ID, DEPT_NAME, DIVISION_ID, REGION_ID FROM TBL_DEPARTMENT";
            // Statement 생성
            statement = connection.createStatement();

            // 쿼리 수행
            resultSet = statement.executeQuery(sql);
//            int result = statement.executeUpdate(sql);

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
