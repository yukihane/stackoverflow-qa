package com.example.so69854209;

import java.util.Optional;

public interface CustomArticleRepository {

    Optional<ArticleDTO> getArticle(long id);

}
