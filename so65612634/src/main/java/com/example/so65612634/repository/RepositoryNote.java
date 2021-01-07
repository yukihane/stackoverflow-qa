package com.example.so65612634.repository;

import com.example.so65612634.model.entity.EntityNote;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Repository
public interface RepositoryNote extends JpaRepository<EntityNote, UUID> {

    EntityNote findByUuid(UUID uuid);

    @Query("SELECT u FROM EntityNote u WHERE u.owner.uuid = :userid ORDER BY u.creationTimestamp DESC")
    List<EntityNote> takeForShortNotes(@Param("userid") UUID userId,
                                       Pageable pageable);

    @Transactional
    @Modifying
    @Query("UPDATE EntityNote u SET u.title = :title, u.content = :content WHERE u.uuid = :uuid")
    void updateNote(@Param("title") String title,
                        @Param("content") String content,
                        @Param("uuid") UUID uuid);

}
