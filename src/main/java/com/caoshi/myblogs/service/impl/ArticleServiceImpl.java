package com.caoshi.myblogs.service.impl;

import com.caoshi.myblogs.domain.Article;
import com.caoshi.myblogs.mapper.ArticleMapper;
import com.caoshi.myblogs.service.ArticleService;
import com.caoshi.myblogs.util.MyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CaoShi on 2019-12-08 10:07:38
 */
@Service
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  private ArticleMapper articleMapper;

  @Override
  public List<Article> getAllByArticleTag(String articleTag) {
    return articleMapper.findAllByArticleTag(articleTag);
  }

  @Override
  public List<Article> getRecoArticles() {
    String[] tagArr = new String[] {"watchers", "career", "python", "java", "web"};
    // 产生两个[0, 5) 之间的不同随机整数
    List<Integer> list = MyUtils.getRandomNumList(2, 0, 5);
    // System.out.println("ArticleServiceImpl.getRecoArticles ---------------  " + list);
    List<Article> articleList = new ArrayList<>();
    for (Integer i : list) {
      List<Article> list1 = articleMapper.findAllByArticleTag(tagArr[i]);
      articleList.addAll(list1);
    }
    return articleList;
  }

  @Override
  public int addArticle(Article article) {
    return articleMapper.insert(article);
  }

  @Override
  public List<Article> getByArticleUerId(Integer articleUserId) {
    return articleMapper.findByArticleUerId(articleUserId);
  }


}
