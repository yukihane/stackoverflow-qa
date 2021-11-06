package com.example.jaso83449;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentRepository extends JpaRepository<Userdetail, String>{
    @Query("SELECT DISTINCT e FROM Userdetail e INNER JOIN e.user WHERE e.user.id LIKE CONCAT(:id,'%') and e.user.name LIKE CONCAT(:name,'%') and e.user.kana LIKE CONCAT(:kana,'%') ORDER BY e.id")
    List<Userdetail> find(@Param("id") String id,
        @Param("name") String name,
        @Param("kana") String kana);

}
