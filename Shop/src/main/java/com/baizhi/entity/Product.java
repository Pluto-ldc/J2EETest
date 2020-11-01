package com.baizhi.entity;

import java.util.Date;

public class Product {

	private Integer id;

	private String name;

	private Double price;

	private Integer sum;

	private Long visitCount;

	private String status;

	private Date addDate;

	private String description;

	private String pic_url;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Long getVisitCount() {
		return visitCount;
	}

	public void setVisitCount(Long visitCount) {
		this.visitCount = visitCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", sum=" + sum + ", visitCount="
				+ visitCount + ", status=" + status + ", addDate=" + addDate + ", description=" + description
				+ ", pic_url=" + pic_url + "]";
	}

	public Product() {

	}

	public Product(Integer id, String name, Double price, Integer sum, Long visitCount, String status, Date addDate,
			String description, String pic_url) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.sum = sum;
		this.visitCount = visitCount;
		this.status = status;
		this.addDate = addDate;
		this.description = description;
		this.pic_url = pic_url;
	}

}
