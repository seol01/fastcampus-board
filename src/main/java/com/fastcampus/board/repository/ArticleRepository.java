package com.fastcampus.board.repository;

import com.fastcampus.board.domain.Article;

import java.util.List;

public interface ArticleRepository {
    List<Article> findAll();

    long count();

    Article save(Article of);
}
