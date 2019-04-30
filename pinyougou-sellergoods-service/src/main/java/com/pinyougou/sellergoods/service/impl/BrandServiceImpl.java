package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbBrandMapper;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.sellergoods.service.BrandService;
import com.pinyougou.util.PageResult;

@Service
public class BrandServiceImpl implements BrandService {

	@Autowired
	private TbBrandMapper tbBrandMapper;
	
	@Override
	public List<TbBrand> findAll() {
		return tbBrandMapper.selectByExample(null);
	}
	
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		// 强转成Page对象
		Page<TbBrand> page= (Page<TbBrand>) tbBrandMapper.selectByExample(null);
		PageResult pageResult = new PageResult("成功", "success", page.getResult(), page.getTotal(), page.getPageNum()); 
		return pageResult;
	}

	@Override
	public void insert(TbBrand tbBrand) {
		tbBrandMapper.insert(tbBrand);		
	}

	@Override
	public TbBrand detail(Long id) {
		return tbBrandMapper.selectByPrimaryKey(id);		
	}

	@Override
	public void update(TbBrand tbBrand) {
		tbBrandMapper.updateByPrimaryKey(tbBrand);
	}

	@Override
	public void delete(Long[] ids) {
		for(Long id : ids) {
			tbBrandMapper.deleteByPrimaryKey(id);
		}
	}

}
