package com.lgcns.icst.lecture.servletjsp.lec4;

public class DepartmentEntity {

    private final String deptId;
    private String deptName;
    private String divisionId;
    private String regionId;

    public DepartmentEntity(String deptId, String deptName, String divisionId, String regionId) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.divisionId = divisionId;
        this.regionId = regionId;
    }

    public String getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public String getRegionId() {
        return regionId;
    }
}
