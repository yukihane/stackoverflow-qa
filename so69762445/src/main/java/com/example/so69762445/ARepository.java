package com.example.so69762445;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ARepository extends CustomizedARepository, JpaRepository<A, Long> {
}
