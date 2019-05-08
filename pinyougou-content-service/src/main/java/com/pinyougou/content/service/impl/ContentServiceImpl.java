package com.pinyougou.content.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.content.service.ContentService;
import com.pinyougou.mapper.TbContentMapper;
import com.pinyougou.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private TbContentMapper contentMapper;

    @Override
    public List<TbContent> findAll1() {
        List<TbContent> contents = contentMapper.selectByExample(null);
        return contents;
    }

    @Override
    public TbContent detail1(Long id) {
        TbContent tbContent = contentMapper.selectByPrimaryKey(id);
        return tbContent;
    }


}
