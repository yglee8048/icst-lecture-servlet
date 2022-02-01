package com.lgcns.icst.lecture.servletjsp.lec5;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FreeBoardDataAccess {

    public List<FreeBoardEntity> findAllFreeBoards() {
        final String DRIVER = "oracle.jdbc.OracleDriver";
        final String URL = "jdbc:oracle:thin:@10.100.70.7:1521:XE";
        List<FreeBoardEntity> result = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // JDBC Driver 로딩
            Class.forName(DRIVER);
            // Connection 획득 (본인의 아이디와 비밀번호 사용)
            connection = DriverManager.getConnection(URL, "student#", "student#");

            // 쿼리
            String sql = "SELECT ID, CONTENT, WRITER_ID, WRITE_DATE FROM FREE_BOARD ORDER BY ID DESC";
            // Statement 생성
            statement = connection.prepareStatement(sql);

            // 쿼리 수행
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                long id = resultSet.getLong("ID");
                String content = resultSet.getString("CONTENT");
                String writerId = resultSet.getString("WRITER_ID");
                Date writeDate = resultSet.getDate("WRITE_DATE");

                result.add(new FreeBoardEntity(id, content, writerId, writeDate));
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
        return result;
    }

    public boolean insertFreeBoard(String content, String writerId) {
        final String DRIVER = "oracle.jdbc.OracleDriver";
        final String URL = "jdbc:oracle:thin:@10.100.70.7:1521:XE";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            // JDBC Driver 로딩
            Class.forName(DRIVER);
            // Connection 획득 (본인의 아이디와 비밀번호 사용)
            connection = DriverManager.getConnection(URL, "student#", "student#");

            // 쿼리
            String sql = "INSERT INTO FREE_BOARD(ID, CONTENT, WRITER_ID, WRITE_DATE) " +
                    "VALUES ((SELECT NVL(MAX(ID),0) + 1 FROM FREE_BOARD), ?, ?, SYSDATE)";
            // Statement 생성
            statement = connection.prepareStatement(sql);
            statement.setString(1, content);
            statement.setString(2, writerId);

            // 쿼리 수행
            int result = statement.executeUpdate();
            return result == 1;

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
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
