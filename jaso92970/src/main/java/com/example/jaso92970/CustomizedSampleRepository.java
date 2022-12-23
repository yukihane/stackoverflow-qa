package com.example.jaso92970;

import java.sql.Date;
import java.util.List;

public interface CustomizedSampleRepository {
    List<SampleEntity> getDate(Date dateForm);
}
