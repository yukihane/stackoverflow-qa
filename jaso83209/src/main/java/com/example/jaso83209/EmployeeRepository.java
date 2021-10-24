package com.example.jaso83209;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //JpaRepository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

  List<Employee> findByEmpnameLike(String string);

}
