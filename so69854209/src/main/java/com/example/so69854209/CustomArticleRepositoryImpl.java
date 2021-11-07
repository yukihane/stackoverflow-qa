package com.example.so69854209;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.transform.BasicTransformerAdapter;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

@Repository
public class CustomArticleRepositoryImpl implements CustomArticleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<ArticleDTO> getArticle(final long id) {
        final Session sess = entityManager.unwrap(Session.class);
        return sess.createNativeQuery(
            "select a.id, a.title, w.name from Article a left outer join Writer w on a.writer_id = w.id where a.id = :id")
            .setParameter("id", id)
            .addScalar("id", LongType.INSTANCE)
            .addScalar("name", StringType.INSTANCE)
            .addScalar("title", StringType.INSTANCE)
            .setResultTransformer(new ArticleResultTransformer())
            .uniqueResultOptional();
    }

    public static class ArticleResultTransformer extends BasicTransformerAdapter {
        @Override
        public Object transformTuple(final Object[] tuple, final String[] aliases) {
            final Optional<String> writerName = Optional.ofNullable((String) tuple[2]);
            final WriterDTO writer = writerName.map(name -> new WriterDTO(name)).orElse(null);

            return new ArticleDTO((Long) tuple[0], (String) tuple[1], writer);
        }
    }
}
