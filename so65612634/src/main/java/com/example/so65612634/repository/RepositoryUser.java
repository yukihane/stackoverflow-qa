package com.example.so65612634.repository;

import com.example.so65612634.model.entity.EntityUser;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository<EntityUser, UUID> {
}
