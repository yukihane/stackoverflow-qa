package com.example.so69898042;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerEntityRepository extends JpaRepository<CustomerEntity, UUID> {
    @Query(nativeQuery = true)
    List<CustomerEntity> findOnlyNameAndPhoneFromCustomer();
}
