package com.caoshi.myblogs.service;

import com.caoshi.myblogs.domain.Tag;

/**
 * Created by CaoShi on 2019/12/8 17:02
 */
public interface TagService {

  /**
   * 根据 标签ID获取标签名称
   * @param tagId
   * @return
   */
  Tag getTagNameByTagId(Integer tagId);


}
