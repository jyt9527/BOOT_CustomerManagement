package cn.jyt.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.jyt.common.utils.Page;
import cn.jyt.crm.mapper.CustomerDao;
import cn.jyt.crm.pojo.Customer;
import cn.jyt.crm.pojo.QueryVo;
import cn.jyt.crm.service.CustomerService;

/**
 * 
 * @ClassName: CustomerServiceImpl
 * @Description: 客户管理ServiceImpl
 * @author: JYT
 * @date: 2019年5月11日 下午8:05:46
 */
@Service
//@Transactional//注解事物
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	// 通过四个条件 查询分页对象
//	public Page<Customer> selectPageByQueryVo(QueryVo vo) {
//		Page<Customer> page = new Page<Customer>();
//		// 每页数
//		page.setSize(10);
//		vo.setSize(10);
//		if (null != vo) {
//			// 判断当前页
//			if (null != vo.getPage()) {
//				page.setPage(vo.getPage());
//				vo.setStartRow((vo.getPage() - 1) * vo.getSize());
//			}
//			// CustName不为空并且
//			if (null != vo.getCustName() && !"".equals(vo.getCustName().trim())) {
//				vo.setCustName(vo.getCustName().trim());
//			}
//			if (null != vo.getCustSource() && !"".equals(vo.getCustSource().trim())) {
//				vo.setCustSource(vo.getCustSource().trim());
//			}
//			if (null != vo.getCustIndustry() && !"".equals(vo.getCustIndustry().trim())) {
//				vo.setCustIndustry(vo.getCustIndustry().trim());
//			}
//			if (null != vo.getCustLevel() && !"".equals(vo.getCustLevel().trim())) {
//				vo.setCustLevel(vo.getCustLevel().trim());
//			}
//			// 总条数
//			page.setTotal(customerDao.customerCountByQueryVo(vo));
//			// 结果集
//			page.setRows(customerDao.selectCustomerListByQueryVo(vo));
//		}
//		return page;
//
//	}
	@Override
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
		// 设置查询条件,从哪一条数据开始查
		queryVo.setStartRow((queryVo.getPage() - 1) * queryVo.getSize());

		// 查询数据结果集
		List<Customer> list = this.customerDao.queryCustomerByQueryVo(queryVo);
		// 查询到的数据总条数
		int total = this.customerDao.customerCountByQueryVo(queryVo);

		// 封装返回的page对象
		Page<Customer> page = new Page<>(total, queryVo.getPage(), queryVo.getSize(), list);

		return page;
	}

	// 通过ID查询客户
	public Customer selectCustomerById(Integer id) {
		return customerDao.selectCustomerById(id);
	}

	// 修改客户通过ID
	public void updateCustomerById(Customer customer) {
		customerDao.updateCustomerById(customer);
	}

	// 通过ID 删除客户
	public void deleteCustomerById(Integer id) {
		customerDao.deleteCustomerById(id);
	}

	public void insertOneCustomer(Customer customer) {
		customerDao.insertOneCustomer(customer);

	}

}
