package com.github.yukihane.so.deps;

import lombok.Data;

@Data
public class EditBean {
    private Object id;
    private Object versionNo;
    private Object deptName;
    private Object deptNo;
    private Object loc;
    private boolean disableId;
    private boolean disableDeptNo;
}
