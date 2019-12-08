package com.caoshi.myblogs.mapper;

import com.caoshi.myblogs.domain.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleMapper {
    int insert(Article record);

    int insertSelective(Article record);

    /**
     * 根据文章标签查询所有文章
     * @param articleTag
     * @return
     */
    List<Article> findAllByArticleTag(String articleTag);

}
