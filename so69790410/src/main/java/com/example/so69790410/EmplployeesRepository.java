package com.example.so69790410;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplployeesRepository extends JpaRepository<TblEmployees, Integer> {
}
