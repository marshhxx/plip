package com.plip.persistence.model;

// Generated Jan 25, 2014 5:33:45 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * PageImage generated by hbm2java
 */
public class PageImage implements java.io.Serializable {

	private Long idPageImage;
	private String path;
	private Set pages = new HashSet(0);

	public PageImage() {
	}

	public PageImage(String path) {
		this.path = path;
	}

	public PageImage(String path, Set pages) {
		this.path = path;
		this.pages = pages;
	}

	public Long getIdPageImage() {
		return this.idPageImage;
	}

	public void setIdPageImage(Long idPageImage) {
		this.idPageImage = idPageImage;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Set getPages() {
		return this.pages;
	}

	public void setPages(Set pages) {
		this.pages = pages;
	}
    
	public boolean validate(){
		if(path!=null){
			return true;
		}else return false;
	}

}
