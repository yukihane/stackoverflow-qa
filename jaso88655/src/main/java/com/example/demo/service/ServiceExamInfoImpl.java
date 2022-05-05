package com.example.demo.service;

import com.example.demo.dao.ExamInfoDao;
import com.example.demo.entity.Info;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceExamInfoImpl implements TestService {

    @Autowired
    ExamInfoDao dao;

    @Autowired
    @Qualifier("Info")
    Info info;

    @Override
    public List selectWhere(Object t) {

        Info info = (Info) t;

        List<Info> list = dao.selectWhere(info);

        return list;

    }
}
