package com.kuangxf.cloud.biz.common;

import java.io.Serializable;
import java.util.List;

public class PageResult<T> extends PageParam implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5136443220495235824L;

	/**
	 * 总的记录数
	 */
	private long total;

	/**
	 * 数据列表
	 */

	private List<T> rows;

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	/**
	 * 计算总的页数
	 * 
	 * @return
	 */
	public Long getTotalPage() {
		if (getTotal() < 0) {
			return 0L;
		}
		if (getPageSize() <= 0) {
			return 0L;
		}
		Long count = getTotal() / getPageSize();
		if (getTotal() % getPageSize() > 0) {
			count++;
		}
		return count;
	}

}
