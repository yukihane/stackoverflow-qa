package com.example.en62093967;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntityRepository extends JpaRepository<MyEntity, Long> {

    @Query("update MyEntity as e set e.message = :message where e.id = :id")
    @Modifying
    @Transactional
    void updateWithoutSelect(long id, String message);
}
