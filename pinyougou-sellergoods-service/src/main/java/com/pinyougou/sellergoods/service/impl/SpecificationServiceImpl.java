package com.pinyougou.sellergoods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import com.pinyougou.pojo.TbSpecificationOptionExample.Criteria;
import com.pinyougou.sellergoods.service.SpecificationService;
import com.pinyougou.vo.SpecificationVO;

@Service
public class SpecificationServiceImpl implements SpecificationService {
	
	@Autowired
	private TbSpecificationMapper specificationMapper;
	@Autowired
	private TbSpecificationOptionMapper specificationOptionMapper;

	@Override
	public SpecificationVO detail(Long id) {
		// 设置VO对象
		SpecificationVO specificationVO = new SpecificationVO();
		// 查询规格名称和ID
		TbSpecification specification = specificationMapper.selectByPrimaryKey(id);
		// 创建查询规格列表查询条件
		TbSpecificationOptionExample example = new TbSpecificationOptionExample();
		Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);
		
		List<TbSpecificationOption> selectByExample = specificationOptionMapper.selectByExample(example);

		// 向VO中添加
		specificationVO.setSpecification(specification);
		specificationVO.setSpecificationOption(selectByExample);
		
		return specificationVO;
	}

	@Override
	public void save(SpecificationVO specificationVO) {
		// 在inser方法中增加返回ID选项。保存成功后会有ID字段
		TbSpecification specification = specificationVO.getSpecification();
		specificationMapper.insert(specification);
		List<TbSpecificationOption> specificationOption = specificationVO.getSpecificationOption();
		
		for(TbSpecificationOption o : specificationOption) {
			o.setSpecId(specification.getId());
			specificationOptionMapper.insert(o);
		}		
	}

}
