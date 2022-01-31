package com.lgcns.icst.lecture.servletjsp.lec4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDept {

    public static void main(String[] args) {
        final String DRIVER = "oracle.jdbc.OracleDriver";
        final String URL = "jdbc:oracle:thin:@10.100.70.7:1521:XE";

        Connection connection = null;
        Statement statement = null;

        try {
            // JDBC Driver 로딩
            Class.forName(DRIVER);
            // Connection 획득 (본인의 아이디와 비밀번호 사용)
            connection = DriverManager.getConnection(URL, "student#", "student#");
            // auto commit = false 로 설정
            connection.setAutoCommit(false);

            // 쿼리
            String sql = "INSERT INTO TBL_DEPARTMENT VALUES ('T13', '보안사업팀', 'DV3', 'D01')";
            // Statement 생성
            statement = connection.createStatement();

            // 쿼리 수행
            int result = statement.executeUpdate(sql);
            System.out.println("result = " + result);
            if (result != 1) {
                System.out.println("fail!");
                connection.rollback();  // 실패 시 rollback 처리한다
            } else {
                System.out.println("success!");
                connection.commit();    // 성공 시 commit 처리한다.
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
