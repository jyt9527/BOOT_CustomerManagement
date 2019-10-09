package cn.jyt.crm.mapper;

import java.util.List;

import cn.jyt.crm.pojo.BaseDict;

public interface BaseDictDao {

	// 查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}
