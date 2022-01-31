package com.lgcns.icst.lecture.servletjsp.lec4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FreeBoardDataAccess {

    public List<FreeBoardEntity> findAllFreeBoards() {
        List<FreeBoardEntity> result = new ArrayList<>();

        final String DRIVER = "oracle.jdbc.OracleDriver";
        final String URL = "jdbc:oracle:thin:@10.100.70.7:1521:XE";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // JDBC Driver 로딩
            Class.forName(DRIVER);
            // Connection 획득 (본인의 아이디와 비밀번호 사용)
            connection = DriverManager.getConnection(URL, "mission303", "mission303");

            // 쿼리
            String sql = "SELECT B_NUM, CONTENT, WRITE_DATE, MID FROM FREE_BOARD";
            // Statement 생성
            statement = connection.prepareStatement(sql);

            // 쿼리 수행
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int bNum = resultSet.getInt("B_NUM");
                String content = resultSet.getString("CONTENT");
                Date writeDate = resultSet.getDate("WRITE_DATE");
                String mid = resultSet.getString("MID");

                result.add(new FreeBoardEntity(bNum, content, writeDate, mid));
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

    public boolean insertFreeBoard(String content, String mid) {
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
            String sql = "INSERT INTO FREE_BOARD VALUES ((SELECT MAX(B_NUM) + 1 FROM FREE_BOARD), ?, SYSDATE, ?)";
            // Statement 생성
            statement = connection.prepareStatement(sql);
            statement.setString(1, content);
            statement.setString(2, mid);

            // 쿼리 수행
            int result = statement.executeUpdate();
            if (result >= 1) {
                return true;
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
        return false;
    }
}
