package com.lgcns.icst.lecture.servletjsp.lec4;

import java.util.List;

public class SelectDeptMain {

    public static void main(String[] args) {
        SelectDeptByEntity selectDeptByEntity = new SelectDeptByEntity();
        List<DepartmentEntity> departments = selectDeptByEntity.findAllDeptHasEmployee();
        for (DepartmentEntity department : departments) {
            System.out.println("department.getDeptName() = " + department.getDeptName());
        }
    }
}
