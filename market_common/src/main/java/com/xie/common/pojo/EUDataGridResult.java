package com.xie.common.pojo;

import java.util.List;

public class EUDataGridResult {
	/*
	 * 查询商品的get和set方法
	 */

	private long total;
	private List<?> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
