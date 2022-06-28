package com.example.demo.repositries;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, String>{
    Optional<Item> findById(String id);
    List<Item> findAll();
}
