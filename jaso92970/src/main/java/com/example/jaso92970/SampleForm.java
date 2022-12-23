package com.example.jaso92970;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


public class SampleForm {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date dateForm;

    public Date getDateForm() {
        return dateForm;
    }

    public void setDateForm(Date dateForm) {
        this.dateForm = dateForm;
    }
}
