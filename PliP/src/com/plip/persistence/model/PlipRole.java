package com.plip.persistence.model;

// Generated Dec 20, 2013 6:41:39 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * PlipRole generated by hbm2java
 */
public class PlipRole implements java.io.Serializable {

	private int idPlipRole;
	private String name;
	private String description;
	private Set plipUsers = new HashSet(0);

	public PlipRole() {
	}

	public PlipRole(int idPlipRole, String name) {
		this.idPlipRole = idPlipRole;
		this.name = name;
	}

	public PlipRole(int idPlipRole, String name, String description,
			Set plipUsers) {
		this.idPlipRole = idPlipRole;
		this.name = name;
		this.description = description;
		this.plipUsers = plipUsers;
	}

	public int getIdPlipRole() {
		return this.idPlipRole;
	}

	public void setIdPlipRole(int idPlipRole) {
		this.idPlipRole = idPlipRole;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set getPlipUsers() {
		return this.plipUsers;
	}

	public void setPlipUsers(Set plipUsers) {
		this.plipUsers = plipUsers;
	}

}