package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.User;

/**
 * ユーザー情報 Repository
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //ここの親クラスにfindAllメソッドが存在しているので全件取得することができる
}