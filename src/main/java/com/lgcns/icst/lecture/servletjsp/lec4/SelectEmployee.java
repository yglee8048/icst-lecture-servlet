package com.lgcns.icst.lecture.servletjsp.lec4;

import java.sql.*;

public class SelectEmployee {

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
            connection = DriverManager.getConnection(URL, "mission303", "mission303");
            
            // 쿼리
            String sql = "SELECT EMP_NO, EMP_NAME FROM TBL_EMPLOYEE";
            // Statement 생성
            statement = connection.createStatement();

            // 쿼리 수행
            resultSet = statement.executeQuery(sql);
            // 수행 결과 출력
            while (resultSet.next()) {
                String empNo = resultSet.getString("EMP_NO");
                String empName = resultSet.getString("EMP_NAME");
                System.out.println(empNo + " : " + empName);
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
