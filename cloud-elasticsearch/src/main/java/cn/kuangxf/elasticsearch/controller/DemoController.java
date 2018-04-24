package cn.kuangxf.elasticsearch.controller;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.kuangxf.elasticsearch.dao.domain.MerchDo;
import cn.kuangxf.elasticsearch.dao.manager.IMerchManager;

@RestController
public class DemoController {

	@Autowired
	IMerchManager merchManager;

	@RequestMapping("/test")
	public String test(MerchDo entity) {
		merchManager.save(entity);
		return "success";
	}

	@RequestMapping("/query")
	public List<MerchDo> query(String search) {
		String queryString = search;// 搜索关键字
		QueryStringQueryBuilder builder = new QueryStringQueryBuilder(queryString);
		Iterable<MerchDo> tempQuery = merchManager.search(builder);
		List<MerchDo> list = new ArrayList<>();
		for (MerchDo merchDo : tempQuery) {
			list.add(merchDo);
		}
		return list;
	}

}
