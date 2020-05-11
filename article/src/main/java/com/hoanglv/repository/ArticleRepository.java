package com.hoanglv.repository;

import com.hoanglv.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
