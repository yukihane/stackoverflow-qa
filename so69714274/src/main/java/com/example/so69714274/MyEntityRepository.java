package com.example.so69714274;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {

    @Query(
        value = "select * from my_entity where (COALESCE(:names, NULL) IS NULL OR (cast(name as VARCHAR) IN (:names)))",
        nativeQuery = true)
    List<MyEntity> filterByName(@Param("names") List<String> names);
}
