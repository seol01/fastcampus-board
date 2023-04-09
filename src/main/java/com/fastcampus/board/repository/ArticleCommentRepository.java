package com.fastcampus.board.repository;

import com.fastcampus.board.domain.Article;
import com.fastcampus.board.domain.ArticleComment;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleCommentRepository extends
        JpaRepository<Article, Long>,
        QuerydslPredicateExecutor<ArticleComment>,
        QuerydslBinderCustomizer<QArticleComment>{
    // 검색 조건값을 설정한다.
    @Override
    default void customize(QuerydslBindings bindings, QArticleComment root) {
        // 검색이 열려있는 모든 값을 가져온다.
        bindings.excludeUnlistedProperties(true);
        // 원하는 필드를 생성
        bindings.including(root.content, root.createdAt, root.createdBy);
//        bindings.bind(root.title).first(StringExpression::likeIgnoreCase); // like '${v}'
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase); // like '%${v}%'
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.creatdBy).first(StringExpression::containsIgnoreCase);
    }
}

