package com.example.so69834330;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long>{

    Optional<Keyword> findKeywordsByKeyword(String keyword);

}
