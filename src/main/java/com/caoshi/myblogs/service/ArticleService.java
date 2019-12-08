package com.caoshi.myblogs.service;

import com.caoshi.myblogs.domain.Article;

import java.util.List;

/**
 * 博客文章业务层接口
 * Created by CaoShi on 2019-12-08 09:38:21
 */
public interface ArticleService {

  /**
   * 根据博客文章标题查询所有博客文章
   * @param articleTag
   * @return
   */
  List<Article> getAllByArticleTag(String articleTag);

  /**
   *  获取给用户推荐的文章
   * @return
   */
  List<Article> getRecoArticles();

  /**
   * 新增博客文章
   * @param article
   * @return
   */
  int addArticle(Article article);



}
