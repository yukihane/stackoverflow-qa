package com.example.demo.entity;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("Info")
public class Info implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private int examId;
    private String examName;
    private String examDate;
    
    public int getExamId() {
        return examId;
    }


    public void setExamId(int examId) {
        this.examId = examId;
    }


    public void setExamName(String examName) {
        this.examName = examName;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public String getExamName() {
        return examName;
    }

    public String getExamDate() {
        return examDate;
    }

}

