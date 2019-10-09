package cn.jyt.crm.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.jyt.common.utils.Page;
import cn.jyt.crm.pojo.Customer;
import cn.jyt.crm.pojo.QueryVo;
import cn.jyt.crm.service.CustomerService;

public class JunitTestService {
	@Test
	public void testMapper() throws Exception {
		// 引入配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");

		CustomerService customerService = ac.getBean(CustomerService.class);

		Customer customer = customerService.selectCustomerById(22);
		System.out.println(customer);
	}

	@Test
	public void testMapper2() throws Exception {
		// 引入配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");

		CustomerService customerService = ac.getBean(CustomerService.class);
		QueryVo queryVo = new QueryVo();
		queryVo.setPage(5);
		queryVo.setSize(5);
		queryVo.setStartRow(22);
		Page<Customer> customers = customerService.queryCustomerByQueryVo(queryVo);
		System.out.println(customers);
	}
}
