package com.pinyougou.content.service;

import com.pinyougou.pojo.TbContent;

import java.util.List;

public interface ContentService {

    public List<TbContent> findAll1();

    public TbContent detail1(Long id);

}
