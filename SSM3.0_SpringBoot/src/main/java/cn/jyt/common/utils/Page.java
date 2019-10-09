package cn.jyt.common.utils;

import java.util.List;

/**
 * 
 * @ClassName: Page
 * @Description: 分页工具类
 * @author: JYT
 * @date: 2019年5月11日 下午2:55:43
 * @param <T>
 */
public class Page<T> {

	private int total;//总条数
	private int page;//当前页
	private int size;//每页显示几条数据
	private List<T> rows;//每页显示的数据list

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public Page() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Page(int total, int page, int size, List<T> rows) {
		super();
		this.total = total;
		this.page = page;
		this.size = size;
		this.rows = rows;
	}

}
