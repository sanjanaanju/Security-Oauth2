package com.project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Technology extends BaseIdEntity {
	
	@Column
	private  String technology;
	
	public String getTechnology() {
		return technology;
	}
	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
}