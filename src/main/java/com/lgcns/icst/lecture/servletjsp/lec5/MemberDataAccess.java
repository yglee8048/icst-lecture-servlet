package com.lgcns.icst.lecture.servletjsp.lec5;

import java.sql.*;

public class MemberDataAccess {

    public MemberEntity findMemberByIdAndPassword(String memberId, String memberPassword) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            connection = DriverManager.getConnection("jdbc:oracle:thin:@10.100.70.7:1521:XE", "mission303", "mission303");

            String sql = "SELECT MEMBERNAME FROM MEMBER WHERE MEMBERID = ? AND MEMBERPWD = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, memberId);
            preparedStatement.setString(2, memberPassword);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String memberName = resultSet.getString("MEMBERNAME");
                return new MemberEntity(memberId, memberPassword, memberName);
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
