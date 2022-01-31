package com.lgcns.icst.lecture.servletjsp.lec4;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SelectDeptByEntity {

    public List<DepartmentEntity> findAllDeptHasEmployee() {
        List<DepartmentEntity> result = new ArrayList<>();

        final String DRIVER = "oracle.jdbc.OracleDriver";
        final String URL = "jdbc:oracle:thin:@10.100.70.7:1521:XE";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // JDBC Driver 로딩
            Class.forName(DRIVER);
            // Connection 획득 (본인의 아이디와 비밀번호 사용)
            connection = DriverManager.getConnection(URL, "student#", "student#");

            // 쿼리
            String sql = "SELECT DISTINCT D.DEPT_ID, D.DEPT_NAME, D.DIVISION_ID, D.REGION_ID FROM TBL_DEPARTMENT D " +
                    "LEFT JOIN TBL_EMPLOYEE TE on D.DEPT_ID = TE.EMP_DEPTID " +
                    "WHERE TE.EMP_NO IS NOT NULL";
            // Statement 생성
            statement = connection.prepareStatement(sql);

            // 쿼리 수행
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String deptId = resultSet.getString("DEPT_ID");
                String deptName = resultSet.getString("DEPT_NAME");
                String divisionId = resultSet.getString("DIVISION_ID");
                String regionId = resultSet.getString("REGION_ID");

                result.add(new DepartmentEntity(deptId, deptName, divisionId, regionId));
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
        return result;  // 에러가 catch 된 경우에도 return 하기 위해 마지막에 적는다.
    }
}
