package com.fastcampus.board.repository;

import com.fastcampus.board.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleCommentRepository extends JpaRepository<Article, Long> {

}
