package com.plip.persistence.model;

// Generated Dec 20, 2013 7:47:29 PM by Hibernate Tools 4.0.0

/**
 * TrayProductId generated by hbm2java
 */
public class TrayProductId implements java.io.Serializable {

	private long trayIdTray;
	private long productsIdProduct;

	public TrayProductId() {
	}

	public TrayProductId(long trayIdTray, long productsIdProduct) {
		this.trayIdTray = trayIdTray;
		this.productsIdProduct = productsIdProduct;
	}

	public long getTrayIdTray() {
		return this.trayIdTray;
	}

	public void setTrayIdTray(long trayIdTray) {
		this.trayIdTray = trayIdTray;
	}

	public long getProductsIdProduct() {
		return this.productsIdProduct;
	}

	public void setProductsIdProduct(long productsIdProduct) {
		this.productsIdProduct = productsIdProduct;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TrayProductId))
			return false;
		TrayProductId castOther = (TrayProductId) other;

		return (this.getTrayIdTray() == castOther.getTrayIdTray())
				&& (this.getProductsIdProduct() == castOther
						.getProductsIdProduct());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getTrayIdTray();
		result = 37 * result + (int) this.getProductsIdProduct();
		return result;
	}

}
