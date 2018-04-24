package cn.kuangxf.elasticsearch.dao.manager;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import cn.kuangxf.elasticsearch.dao.domain.MerchDo;

public interface IMerchManager extends ElasticsearchRepository<MerchDo, Long> {

}
