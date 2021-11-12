package com.example.so22663502;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class SomeEntityRepository {

    @PersistenceContext
    private EntityManager em;

    public List<SomeClass> method() {
        final String query = "SELECT " +
            "A.id AS id, " +
            "A.name AS NAME, " +
            "A.begDate AS DATE_BEGIN " +
            "FROM " +
            "SomeTable A " +
            "WHERE A.endDate < '2014-01-01'";

        final List<SomeClass> result = em.createNativeQuery(query, "SomeMapping").getResultList();
        return result;
    }

}
