package com.plip.persistence.model;

// Generated Dec 20, 2013 6:41:39 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

/**
 * Position generated by hbm2java
 */
public class Position implements java.io.Serializable {

	private int idPosition;
	private int face;
	private int angle;
	private Set images = new HashSet(0);

	public Position() {
	}

	public Position(int idPosition, int face, int angle) {
		this.idPosition = idPosition;
		this.face = face;
		this.angle = angle;
	}

	public Position(int idPosition, int face, int angle, Set images) {
		this.idPosition = idPosition;
		this.face = face;
		this.angle = angle;
		this.images = images;
	}

	public int getIdPosition() {
		return this.idPosition;
	}

	public void setIdPosition(int idPosition) {
		this.idPosition = idPosition;
	}

	public int getFace() {
		return this.face;
	}

	public void setFace(int face) {
		this.face = face;
	}

	public int getAngle() {
		return this.angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	public Set getImages() {
		return this.images;
	}

	public void setImages(Set images) {
		this.images = images;
	}

}