package cn.jyt.crm.service;

import cn.jyt.common.utils.Page;
import cn.jyt.crm.pojo.Customer;
import cn.jyt.crm.pojo.QueryVo;

public interface CustomerService {
	// 通过四个条件 查询分页对象
	// public Page<Customer> selectPageByQueryVo(QueryVo vo);
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);

	// 通过ID查询客户
	public Customer selectCustomerById(Integer id);

	// 修改客户通过ID
	public void updateCustomerById(Customer customer);

	// 通过ID 删除客户
	public void deleteCustomerById(Integer id);

	// 添加用户
	public void insertOneCustomer(Customer customer);
}
