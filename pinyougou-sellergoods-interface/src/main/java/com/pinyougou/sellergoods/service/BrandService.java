package com.pinyougou.sellergoods.service;

import java.util.List;

import com.pinyougou.pojo.TbBrand;
import com.pinyougou.util.PageResult;

public interface BrandService {
	
	public List<TbBrand> findAll();

	/**
	 * 分页查询
	 * @param pageNum 当前页
	 * @param PageSize 页大小
	 * @return
	 */
	public PageResult findPage(int pageNum, int PageSize);
}
