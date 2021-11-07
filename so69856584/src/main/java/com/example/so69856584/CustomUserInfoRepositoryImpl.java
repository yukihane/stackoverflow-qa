package com.example.so69856584;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

@Repository
public class CustomUserInfoRepositoryImpl implements CustomUserInfoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Class<?> getDomain() {
        return UserInfo.class;
    }

    @Override
    public List<UserInfo> getAll() {
        final Session sess = entityManager.unwrap(Session.class);
        return sess.createQuery("FROM " + getDomain().getName())
            .getResultList();
    }

}
