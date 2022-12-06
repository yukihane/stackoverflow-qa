package examples.jpa;

import examples.Subject;
import examples.Term;
import examples.jpa.entity.Score;
import lombok.AccessLevel;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static org.hibernate.testing.transaction.TransactionUtil.doInHibernate;
import static org.hibernate.testing.transaction.TransactionUtil.doInJPA;

public class ScoreTest {

    @Getter(AccessLevel.PRIVATE)
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example.unit");

    @Getter
    private final SessionFactory sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);

    @Test
    public void test() {
        doInJPA(this::getEntityManagerFactory, em -> {
            persist(em, "山田", YearMonth.of(2022, 4), 1, 60, 43, 72);
            persist(em, "山田", YearMonth.of(2022, 5), 1, 63, 52, 68);
            persist(em, "山田", YearMonth.of(2022, 6), 1, 64, 56, 64);
            persist(em, "山田", YearMonth.of(2022, 9), 2, 63, 53, 72);
            persist(em, "山田", YearMonth.of(2022, 10), 2, 67, 59, 64);
            persist(em, "山田", YearMonth.of(2022, 11), 2, 59, 62, 63);
        });

        doInHibernate(this::getSessionFactory, session -> {
            NativeQuery q = session.createNativeQuery("select term, avg(japanese), avg(math), avg(english) from score where name='山田' group by term");
            List<Object[]> qr = q.list();
            var queryResultList = qr.stream().map(r -> {
                int term = (int) r[0];
                double avgJapanese = (double) r[1];
                double avgMath = (double) r[2];
                double avgEnglish = (double) r[3];
                System.out.println("Map.of(\"学期\", " + term + ", \"国語\", " + avgJapanese + ", \"数学\", " + avgMath + ", \"英語\", " + avgEnglish + ")");
                return Map.of("学期", term, "国語", avgJapanese, "数学", avgMath, "英語", avgEnglish);
            }).toList();

            var averages = queryResultList.stream().collect(Collectors.toMap(
                    e -> {
                        var termValue = e.get("学期").intValue();
                        return Term.from(termValue);
                    },
                    e -> {
                        var qrMap = new HashMap<>(e);
                        qrMap.remove("学期");

                        return qrMap.entrySet().stream().collect(Collectors.toMap(
                                f -> Subject.from(f.getKey()),
                                f -> f.getValue().doubleValue(),
                                (f1, f2) -> f2,
                                TreeMap::new
                        ));
                    },
                    (e1, e2) -> e2,
                    TreeMap::new
            ));

            for (Subject s : Subject.values()) {
                for (Term t : Term.values()) {
                    var avg = averages.get(t).get(s);
                    System.out.printf("%.2f\t", avg);
                }
                System.out.println();
            }

        });
    }

    private void persist(EntityManager em, String name, YearMonth yearMonth, int term, int japanese, int math, int english) {
        final Score p = new Score();
        p.setName(name);
        p.setYearMonth(yearMonth);
        p.setTerm(term);
        p.setJapanese(japanese);
        p.setMath(math);
        p.setEnglish(english);
        em.persist(p);
    }


    @Test
    public void testWithoutDB() {
        var queryResultList = List.of(
                Map.of("学期", 1, "国語", 62.33, "数学", 50.33, "英語", 68.0),
                Map.of("学期", 2, "国語", 63.0, "数学", 58.0, "英語", 66.33)
        );

        var averages = queryResultList.stream().collect(Collectors.toMap(
                e -> {
                    var termValue = e.get("学期").intValue();
                    return Term.from(termValue);
                },
                e -> {
                    var qrMap = new HashMap<>(e);
                    qrMap.remove("学期");

                    return qrMap.entrySet().stream().collect(Collectors.toMap(
                            f -> Subject.from(f.getKey()),
                            f -> f.getValue().doubleValue()
                    ));
                }
        ));

        for (Subject s : Subject.values()) {
            for (Term t : Term.values()) {
                var avg = averages.get(t).get(s);
                System.out.printf("%.2f\t", avg);
            }
            System.out.println();
        }

        System.out.println();

        for (Term t : Term.values()) {
            for (Subject s : Subject.values()) {
                var avg = averages.get(t).get(s);
                System.out.printf("%.2f\t", avg);
            }
            System.out.println();
        }
    }
}
