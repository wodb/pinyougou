package com.pinyougou.manager.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.util.PageResult;
import com.pinyougou.util.ResultUtil;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Reference
	private BrandService brandService;
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<TbBrand> findAll() {
		return brandService.findAll();
	}
	
	@RequestMapping(value = "/findPage", method = RequestMethod.GET)
	public PageResult findPage(int pageNum, int pageSize) {

		return brandService.findPage(pageNum, pageSize); 
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ResultUtil insert(TbBrand tbBrand) {
		try {
			brandService.insert(tbBrand);
			return new ResultUtil("success", "添加成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultUtil("error", e.getMessage(), null);
		}
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public ResultUtil detail(Long id) {
		try {
			TbBrand t = brandService.detail(id);
			return new ResultUtil("success", "添加成功", t);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultUtil("error", e.getMessage(), null);
		}
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResultUtil update(TbBrand tbBrand) {
		try {
			brandService.update(tbBrand);
			return new ResultUtil("success", "修改成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultUtil("error", e.getMessage(), null);
		}
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ResultUtil delete(Long[] ids) {
		try {
			brandService.delete(ids);
			return new ResultUtil("success", "删除成功", null);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResultUtil("error", e.getMessage(), null);
		}
	}
}
