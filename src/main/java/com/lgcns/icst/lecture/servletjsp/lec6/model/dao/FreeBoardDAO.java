package com.lgcns.icst.lecture.servletjsp.lec6.model.dao;

import com.lgcns.icst.lecture.servletjsp.lec6.model.entity.FreeBoardEntity;
import com.lgcns.icst.lecture.servletjsp.lec6.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FreeBoardDAO {

    public List<FreeBoardEntity> findAllFreeBoards(Connection connection) throws SQLException {
        List<FreeBoardEntity> result = new ArrayList<>();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 쿼리
            String sql = "SELECT B_NUM, CONTENT, WRITE_DATE, MID FROM FREE_BOARD ORDER BY B_NUM DESC";
            // Statement 생성
            preparedStatement = connection.prepareStatement(sql);

            // 쿼리 수행
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int bNum = resultSet.getInt("B_NUM");
                String content = resultSet.getString("CONTENT");
                Date writeDate = resultSet.getDate("WRITE_DATE");
                String mid = resultSet.getString("MID");

                result.add(new FreeBoardEntity(bNum, content, writeDate, mid));
            }
            return result;

        } finally {
            // 생성한 역순으로 반환(close)한다.
            JdbcUtil.close(resultSet);
            JdbcUtil.close(preparedStatement);
        }
    }

    public boolean insertFreeBoard(Connection connection, String content, String memberName) throws SQLException {

        PreparedStatement preparedStatement = null;
        try {
            // 쿼리
            String sql = "INSERT INTO FREE_BOARD VALUES ((SELECT MAX(B_NUM) + 1 FROM FREE_BOARD), ?, SYSDATE, ?)";
            // Statement 생성
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, content);
            preparedStatement.setString(2, memberName);

            // 쿼리 수행
            int result = preparedStatement.executeUpdate();
            System.out.println("result = " + result);
            return result == 1;
        } finally {
            // 생성한 역순으로 반환(close)한다.
            JdbcUtil.close(preparedStatement);
        }
    }

    public FreeBoardEntity findFreeBoardByBNum(Connection connection, Integer bNum) throws SQLException {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 쿼리
            String sql = "SELECT CONTENT, WRITE_DATE, MID FROM FREE_BOARD WHERE B_NUM = ?";
            // Statement 생성
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bNum);

            // 쿼리 수행
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String content = resultSet.getString("CONTENT");
                Date writeDate = resultSet.getDate("WRITE_DATE");
                String mid = resultSet.getString("MID");

                return new FreeBoardEntity(bNum, content, writeDate, mid);
            }
            return null;

        } finally {
            // 생성한 역순으로 반환(close)한다.
            JdbcUtil.close(resultSet);
            JdbcUtil.close(preparedStatement);
        }
    }

    public boolean updateFreeBoard(Connection connection, Integer bNum, String content) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE FREE_BOARD SET CONTENT = ? AND WRITE_DATE = SYSDATE WHERE B_NUM = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, content);
            preparedStatement.setInt(2, bNum);

            int result = preparedStatement.executeUpdate();
            return result == 1;

        } finally {
            JdbcUtil.close(preparedStatement);
        }
    }

    public boolean deleteFreeBoard(Connection connection, Integer bNum) throws SQLException {
        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM FREE_BOARD WHERE B_NUM = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, bNum);

            int result = preparedStatement.executeUpdate();
            return result == 1;

        } finally {
            JdbcUtil.close(preparedStatement);
        }
    }
}
