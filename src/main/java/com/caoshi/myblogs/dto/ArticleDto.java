package com.caoshi.myblogs.dto;

import lombok.Data;
import lombok.ToString;

/**
 * Article 实体 DTO
 * Created by CaoShi on 2019/12/8 15:53
 */
@Data
@ToString
public class ArticleDto {

  /**
   * 文章标题
   */
  private String title;

  /**
   * 文章标签ID
   */
  private Integer TagId;

  /**
   * 文章内容
   */
  private String content;

}
