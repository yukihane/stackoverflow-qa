package com.example.jaso92970;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SampleService {

    @Autowired
    SampleRepository repository;

    @PersistenceContext
    private EntityManager entityManager;

    public List<SampleEntity> searchForm(SampleForm sampleForm) {
        List<SampleEntity> list = repository.getDate(null);
        return list;
    }
}
