package cn.jyt.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.jyt.common.utils.Page;
import cn.jyt.crm.pojo.BaseDict;
import cn.jyt.crm.pojo.Customer;
import cn.jyt.crm.pojo.QueryVo;
import cn.jyt.crm.service.BaseDictService;
import cn.jyt.crm.service.CustomerService;

/**
 * 
 * @ClassName: CustomerController
 * @Description: 客户管理
 * @author: JYT
 * @date: 2019年5月11日 下午3:01:49
 */
@Controller
public class CustomerController {

	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;

	// 注解在成员变量上
	@Value("${fromType.code}")
	private String fromTypeCode;

	@Value("${industryType.code}")
	private String industryTypeCode;

	@Value("${levelType.code}")
	private String levelTypeCode;

	// 入口
	@RequestMapping(value = "/customer/list")
	public String list(QueryVo vo, Model model) {
		// 引入数据字典的查询
		// 方法一：直接写数值
//		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode("002");
//		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode("001");
//		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode("006");
		// （推荐使用）方法二：使用resource.properties读取
		List<BaseDict> fromType = baseDictService.selectBaseDictListByCode(fromTypeCode);
		List<BaseDict> industryType = baseDictService.selectBaseDictListByCode(industryTypeCode);
		List<BaseDict> levelType = baseDictService.selectBaseDictListByCode(levelTypeCode);
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);

		// 通过四个条件 查询分页对象
		// Page<Customer> page = customerService.selectPageByQueryVo(vo);
		Page<Customer> page = customerService.queryCustomerByQueryVo(vo);
		model.addAttribute("page", page);

		// 回显
		model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());

		return "customer";
	}

	// 去修改页面
	@RequestMapping(value = "/customer/edit.action")
	public @ResponseBody Customer edit(Integer id) {
		return customerService.selectCustomerById(id);
	}

	// 修改保存
	@RequestMapping(value = "/customer/update.action")
	public @ResponseBody String update(Customer customer) {
		// 修改
		customerService.updateCustomerById(customer);
		return "OK";
	}

	// 保存用户
	@RequestMapping(value = "/customer/save.action")
	public @ResponseBody String save(Customer customer) {
		// 保存
		customerService.insertOneCustomer(customer);
		return "OK";
	}

	// 删除
	@RequestMapping(value = "/customer/delete.action")
	public @ResponseBody String delete(Integer id) {
		// 删除
		customerService.deleteCustomerById(id);
		return "OK";
	}

}
