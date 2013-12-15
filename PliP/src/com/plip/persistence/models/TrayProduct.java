package com.plip.persistence.models;

// Generated Dec 15, 2013 8:06:54 PM by Hibernate Tools 3.4.0.CR1

/**
 * TrayProduct generated by hbm2java
 */
public class TrayProduct implements java.io.Serializable {

	private TrayProductId id;
	private Product product;
	private Tray tray;
	private int quantity;

	public TrayProduct() {
	}

	public TrayProduct(TrayProductId id, Product product, Tray tray,
			int quantity) {
		this.id = id;
		this.product = product;
		this.tray = tray;
		this.quantity = quantity;
	}

	public TrayProductId getId() {
		return this.id;
	}

	public void setId(TrayProductId id) {
		this.id = id;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Tray getTray() {
		return this.tray;
	}

	public void setTray(Tray tray) {
		this.tray = tray;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
