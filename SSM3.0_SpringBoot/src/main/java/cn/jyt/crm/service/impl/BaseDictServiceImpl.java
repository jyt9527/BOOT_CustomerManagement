package cn.jyt.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jyt.crm.mapper.BaseDictDao;
import cn.jyt.crm.pojo.BaseDict;
import cn.jyt.crm.service.BaseDictService;

@Service
//@Transactional//注解事物
public class BaseDictServiceImpl implements BaseDictService {
	@Autowired // 自动装载
//	@Resource(name = "baseDictDao") // 指定
	private BaseDictDao baseDictDao;

	public List<BaseDict> selectBaseDictListByCode(String code) {
		// TODO Auto-generated method stub
		return baseDictDao.selectBaseDictListByCode(code);
	}

}
