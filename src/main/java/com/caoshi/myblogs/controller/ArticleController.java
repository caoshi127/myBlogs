package com.caoshi.myblogs.controller;

import com.caoshi.myblogs.domain.Article;
import com.caoshi.myblogs.domain.User;
import com.caoshi.myblogs.dto.ArticleDto;
import com.caoshi.myblogs.service.ArticleService;
import com.caoshi.myblogs.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 博客文章控制器
 * 2019年12月7日17:38:40
 */
@Controller
@RequestMapping("art")
public class ArticleController {

  @Autowired
  private ArticleService articleService;

  @Autowired
  private TagService tagService;

  /**
   * 根据标签显示文章
   * @param tag
   * @param model
   * @return
   */
  @RequestMapping(value = "/{tag}")
  public String getByArticleTag(@PathVariable String tag, Model model) {
    List<Article> articles;
    if (!("reco".equals(tag))) {    // 不是推荐的文章
      articles = articleService.getAllByArticleTag(tag);
    } else {
      articles = articleService.getRecoArticles();
    }
    model.addAttribute("articles", articles);
    return "/content/content";
  }

  /**
   * 跳转到写博客页面
   * @return
   */
  @RequestMapping("/add")
  public String toAdd() {
    return "/blogs/add";
  }

  /**
   * 新增文章提交
   * @param session
   * @param articleDto
   * @return
   */
  @RequestMapping("/addSubmit")
  public String addArticleSubmit(HttpSession session, ArticleDto articleDto) {
    Article article = new Article();

    // 获取用户(即文章作者)
    User user = (User) session.getAttribute("user");
    // 获取标签 ID
    Integer tagId = articleDto.getTagId();

    // 封装article对象
    article.setArticleTitle(articleDto.getTitle());
    article.setArticleTag(tagService.getTagNameByTagId(tagId).getTagName());
    article.setArticleContent(articleDto.getContent());
    article.setArticleUserId(user.getId());

    articleService.addArticle(article);
    return "/blogs/main";
  }



}
