package com.example.en62396625;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface visitorrepository extends JpaRepository<newvisitor, Long> {
}
