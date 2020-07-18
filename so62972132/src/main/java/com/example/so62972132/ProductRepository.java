package com.example.so62972132;

import com.example.so62972132.entity.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductDetail, Integer>{

}
