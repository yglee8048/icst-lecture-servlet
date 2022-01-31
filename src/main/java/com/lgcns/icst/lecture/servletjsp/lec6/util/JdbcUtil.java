package com.lgcns.icst.lecture.servletjsp.lec6.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;

@Component
public class JdbcUtil {

    private static DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        JdbcUtil.dataSource = dataSource;
    }

    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        // JDBC Driver 로딩
        Class.forName("oracle.jdbc.OracleDriver");
        // Connection 획득 (본인의 아이디와 비밀번호 사용)
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@10.100.70.7:1521:XE", "mission303", "mission303");
        return connection;
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(false);
        return connection;
    }

    public static void commit(Connection connection) throws SQLException {
        if (connection != null) {
            connection.commit();
            System.out.println("JdbcUtils.commit: Commit!");
        } else {
            System.out.println("JdbcUtils.commit: connection is null!");
        }
    }

    public static void rollback(Connection connection) throws SQLException {
        if (connection != null) {
            connection.rollback();
            System.out.println("JdbcUtils.rollback: Rollback!");
        } else {
            System.out.println("JdbcUtils.rollback: connection is null!");
        }
    }

    public static void close(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(PreparedStatement preparedStatement) {
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
