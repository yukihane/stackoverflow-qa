package com.example.jaso91830;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDataRepository extends JpaRepository<MyData, Long> {
}
