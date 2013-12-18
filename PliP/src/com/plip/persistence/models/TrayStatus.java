package com.plip.persistence.models;

// Generated Dec 18, 2013 12:11:56 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * TrayStatus generated by hbm2java
 */
public class TrayStatus implements java.io.Serializable {

	private TrayStatusId id;
	private Product product;
	private Tray tray;
	private Status status;
	private Integer quantity;
	private Date date;

	public TrayStatus() {
	}

	public TrayStatus(TrayStatusId id, Tray tray, Status status) {
		this.id = id;
		this.tray = tray;
		this.status = status;
	}

	public TrayStatus(TrayStatusId id, Product product, Tray tray,
			Status status, Integer quantity, Date date) {
		this.id = id;
		this.product = product;
		this.tray = tray;
		this.status = status;
		this.quantity = quantity;
		this.date = date;
	}

	public TrayStatusId getId() {
		return this.id;
	}

	public void setId(TrayStatusId id) {
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

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}