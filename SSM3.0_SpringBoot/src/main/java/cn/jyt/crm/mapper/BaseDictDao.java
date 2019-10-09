package cn.jyt.crm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.jyt.crm.pojo.BaseDict;
@Mapper
public interface BaseDictDao {

	// 查询
	public List<BaseDict> selectBaseDictListByCode(String code);
}
