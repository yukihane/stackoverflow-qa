package com.example.en62333696;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {
    
    @Query(value = "SELECT name FROM Citizen c, Police p, Arrest a WHERE c.id = p.id AND a.id = p.id AND a.duration = ?1")
public List<Citizen> getCitizenByDuration(int duration);


    public List<Citizen> getCitizenById(long Id);



    

}