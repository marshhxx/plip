package com.plip.persistence.models;

// Generated Dec 18, 2013 12:11:56 PM by Hibernate Tools 4.0.0

/**
 * PageProduct generated by hbm2java
 */
public class PageProduct implements java.io.Serializable {

	private PageProductId id;
	private Product product;
	private Page page;
	private Integer quantity;

	public PageProduct() {
	}

	public PageProduct(PageProductId id, Product product, Page page) {
		this.id = id;
		this.product = product;
		this.page = page;
	}

	public PageProduct(PageProductId id, Product product, Page page,
			Integer quantity) {
		this.id = id;
		this.product = product;
		this.page = page;
		this.quantity = quantity;
	}

	public PageProductId getId() {
		return this.id;
	}

	public void setId(PageProductId id) {
		this.id = id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Page getPage() {
		return this.page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
