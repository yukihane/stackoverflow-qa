package com.example.so69854209;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long>, CustomArticleRepository {

}
