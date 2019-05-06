package com.pinyougou.vo;

import java.io.Serializable;
import java.util.List;

import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationOption;


public class SpecificationVO implements Serializable {

	private static final long serialVersionUID = 1L;

	// 规格
	private TbSpecification specification;
	// 规格选项
	private List<TbSpecificationOption> specificationOption;

	public TbSpecification getSpecification() {
		return specification;
	}

	public void setSpecification(TbSpecification specification) {
		this.specification = specification;
	}

	public List<TbSpecificationOption> getSpecificationOption() {
		return specificationOption;
	}

	public void setSpecificationOption(List<TbSpecificationOption> specificationOption) {
		this.specificationOption = specificationOption;
	}
}
