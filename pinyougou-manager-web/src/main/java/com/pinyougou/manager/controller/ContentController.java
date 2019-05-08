package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.content.service.ContentService;
import com.pinyougou.pojo.TbContent;
import com.pinyougou.util.ResultUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Reference
    private ContentService contentService;

    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public ResultUtil findAll() {

        try {
            List<TbContent> all = contentService.findAll1();
            return new ResultUtil("success","成功", all);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultUtil("error","失败", null);
        }

    }

}
