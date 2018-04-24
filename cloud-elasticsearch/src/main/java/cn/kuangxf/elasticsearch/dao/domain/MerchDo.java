package cn.kuangxf.elasticsearch.dao.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "demo",type = "merch" , shards = 8, replicas = 1) 
public class MerchDo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8536924458105655074L;

	@Id
	private Long id;
	
	private String name;
	
	private BigDecimal price;
	
	private String descript;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}
	
	
}
