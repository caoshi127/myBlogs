package com.caoshi.myblogs.service.impl;

import com.caoshi.myblogs.domain.Tag;
import com.caoshi.myblogs.mapper.TagMapper;
import com.caoshi.myblogs.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by CaoShi on 2019/12/8 17:03
 */

@Service
public class TagServiceImpl implements TagService {

  @Autowired
  private TagMapper tagMapper;

  @Override
  public Tag getTagNameByTagId(Integer tagId) {
    return tagMapper.selectByPrimaryKey(tagId);
  }
}
