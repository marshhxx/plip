package com.plip.persistence.model;

// Generated Dec 26, 2013 8:22:22 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Tray generated by hbm2java
 */
public class Tray implements java.io.Serializable {

	private Long idTray;
	private Page page;
	private String code;
	private Set trayStatuses = new HashSet(0);

	public Tray() {
	}

	public Tray(Page page, String code) {
		this.page = page;
		this.code = code;
	}

	public Tray(Page page, String code, Set trayStatuses) {
		this.page = page;
		this.code = code;
		this.trayStatuses = trayStatuses;
	}

	public Long getIdTray() {
		return this.idTray;
	}

	public void setIdTray(Long idTray) {
		this.idTray = idTray;
	}

	public Page getPage() {
		return this.page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Set getTrayStatuses() {
		return this.trayStatuses;
	}

	public void setTrayStatuses(Set trayStatuses) {
		this.trayStatuses = trayStatuses;
	}

}
