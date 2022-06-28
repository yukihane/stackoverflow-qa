package com.example.demo.repositries;

import com.example.demo.models.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Long>{

}
