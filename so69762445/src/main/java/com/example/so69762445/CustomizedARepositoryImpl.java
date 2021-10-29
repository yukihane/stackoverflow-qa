package com.example.so69762445;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.transform.BasicTransformerAdapter;
import org.springframework.stereotype.Repository;

// https://docs.spring.io/spring-data/jpa/docs/2.5.6/reference/html/#repositories.custom-implementations
@Repository
public class CustomizedARepositoryImpl implements CustomizedARepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<A> getAll() {
        // https://docs.jboss.org/hibernate/orm/5.6/userguide/html_single/Hibernate_User_Guide.html#sql-entity-associations-query
        final Session sess = (Session) entityManager.getDelegate();
        final List<A> res = sess
            .createNativeQuery("select {a.*},{b.*} from A as a left join B as b on a.ID = b.a ")
            .addEntity("a", A.class)
            .addJoin("b", "a.bs")
            .setResultTransformer(DistinctResultTransformer.INSTANCE)
            .list();

        return res;
    }

    // https://stackoverflow.com/q/12071014/4506703
    static class DistinctResultTransformer extends BasicTransformerAdapter {
        private static final long serialVersionUID = 1L;

        static final DistinctResultTransformer INSTANCE = new DistinctResultTransformer();

        @Override
        public List transformList(final List collection) {
            final List<Object> res = new ArrayList<>();
            for (final Object[] obj : (List<Object[]>) collection) {
                if (!res.contains(obj[0])) {
                    res.add(obj[0]);
                }
            }
            return res;
        }
    }
}
