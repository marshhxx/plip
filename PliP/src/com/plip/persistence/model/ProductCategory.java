package com.plip.persistence.model;

// Generated Dec 26, 2013 8:22:22 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * ProductCategory generated by hbm2java
 */
public class ProductCategory implements java.io.Serializable {

	private Long idProductType;
	private String description;
	private Set products = new HashSet(0);

	public ProductCategory() {
	}

	public ProductCategory(String description) {
		this.description = description;
	}

	public Long getIdProductType() {
		return this.idProductType;
	}

	public void setIdProductType(Long idProductType) {
		this.idProductType = idProductType;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getProducts() {
		return this.products;
	}

	public void setProducts(Set products) {
		this.products = products;
	}

}
