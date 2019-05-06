package com.pinyougou.manager.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.sellergoods.service.SpecificationService;
import com.pinyougou.util.ResultUtil;
import com.pinyougou.vo.SpecificationVO;

@RestController
@RequestMapping("/specification")
public class SpecificationController {
	
	@Reference
	private SpecificationService specificationService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResultUtil detail(@PathVariable Long id) {
		try {
			SpecificationVO VO = specificationService.detail(id);
			return new ResultUtil("success", "添加成功", VO);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultUtil("error", e.getMessage(), null);
		}
	}
}
