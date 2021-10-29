package com.example.so69762445;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ARepository extends CustomizedARepository, JpaRepository<A, Long> {

    @Query("select distinct a from A a left join fetch a.bs")
    List<A> getAllJpqlFetch();
}
