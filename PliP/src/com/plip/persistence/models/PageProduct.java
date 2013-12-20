package com.plip.persistence.models;

// Generated Dec 20, 2013 6:41:39 PM by Hibernate Tools 4.0.0

/**
 * PageProduct generated by hbm2java
 */
public class PageProduct implements java.io.Serializable {

	private PageProductId id;
	private Product product;
	private Page page;
	private int quantity;

	public PageProduct() {
	}

	public PageProduct(PageProductId id, Product product, Page page,
			int quantity) {
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

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
