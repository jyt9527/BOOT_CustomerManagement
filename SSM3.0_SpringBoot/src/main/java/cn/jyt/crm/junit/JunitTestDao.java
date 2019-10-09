package cn.jyt.crm.junit;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jyt.crm.mapper.BaseDictDao;
import cn.jyt.crm.mapper.CustomerDao;
import cn.jyt.crm.pojo.BaseDict;
import cn.jyt.crm.pojo.Customer;

public class JunitTestDao {

	@Test
	public void testMapper() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
		CustomerDao customerDao = ac.getBean(CustomerDao.class);
		Customer customer = customerDao.selectCustomerById(22);
		System.out.println(customer.toString());
	}

	@Test
	public void testMapper2() throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
		BaseDictDao baseDictDao = ac.getBean(BaseDictDao.class);
		List<BaseDict> baseDicts = baseDictDao.selectBaseDictListByCode("002");
		System.out.println(baseDicts);
	}
}
