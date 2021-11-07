package com.example.so69856584;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>, CustomUserInfoRepository {
}
