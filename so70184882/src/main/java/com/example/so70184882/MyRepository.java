package com.example.so70184882;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<MyEntity, Integer> {

    @Query("select q from MyEntity q where :name is null or q.name=:name")
    List<MyEntity> getDetails(@Param("name") String name);

}
