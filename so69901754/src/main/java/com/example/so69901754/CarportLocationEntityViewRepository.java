package com.example.so69901754;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarportLocationEntityViewRepository extends JpaRepository<CarportLocationEntityView, Long> {
    @Query("SELECT d FROM CarportLocationEntityView d WHERE d.externalId LIKE %:filterCriteria% OR lower(d.carportName) LIKE lower(concat('%',:filterCriteria,'%')) ")
    List<CarportLocationEntityView> filterCarportList(@Param("filterCriteria") String filterCriteria);
}
