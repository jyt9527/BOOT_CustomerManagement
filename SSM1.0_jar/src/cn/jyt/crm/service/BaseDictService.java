package cn.jyt.crm.service;

import java.util.List;

import cn.jyt.crm.pojo.BaseDict;

public interface BaseDictService {

	// 查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}
