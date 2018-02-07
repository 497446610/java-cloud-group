package com.kuangxf.cloud.biz;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kuangxf.cloud.biz.common.PageParam;
import com.kuangxf.cloud.biz.common.PageResult;
import com.kuangxf.cloud.dao.common.Page;
//import com.kuangxf.cloud.dao.common.Page;

@SuppressWarnings({ "rawtypes" })
public class BaseService {

	/**
	 * 错误日志
	 */
	private final static Logger logger = LoggerFactory.getLogger(BaseService.class);

	public Page query2Page(PageParam pageParam) {
		Page page = new Page(pageParam.getPageIndex(), pageParam.getPageSize());
		return page;
	}

	public <T> PageResult<T> pageList2PageResult(Class<T> clazz, List rows, Page page) {
		PageResult<T> result = new PageResult<T>();
		result.setRows(new ArrayList<T>());
		result.setPageIndex(page.getCurrPage());
		result.setPageSize(page.getPageSize());
		result.setTotal(page.getTotal());

		if (rows == null || rows.isEmpty()) {
			return result;
		}

		for (Object source : rows) {
			try {
				T dest = clazz.newInstance();
				copyProperties(dest, source);
				result.getRows().add(dest);
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	public <T> PageResult<T> emptyPageResult(Class<T> clazz, Page page) {
		PageResult<T> result = new PageResult<T>();
		result.setRows(new ArrayList<T>());
		result.setPageIndex(page.getCurrPage());
		result.setPageSize(page.getPageSize());
		result.setTotal(page.getTotalPages());
		return result;
	}

	public void copyProperties(Object dest, Object source) {
		if (dest == null || source == null) {
			return;
		}

		try {
			BeanUtils.copyProperties(dest, source);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

}
