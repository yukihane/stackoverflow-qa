package com.github.yukihane.so.deps;

public interface DeptDao {

    Object findDeptNo(Object deptNo);

    Object findVersionNo(Object deptNo);

    Dept findById(Object id);

    void update(Dept dept);

    void insert(Dept dept);

}
