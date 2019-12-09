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
     * @param articleTag 文章标签
     * @return
     */
    List<Article> findAllByArticleTag(String articleTag);

    /**
     * 根据用户ID查询文章
     * @param articleUserId 用户ID
     * @return
     */
    List<Article> findByArticleUerId(Integer articleUserId);


}
