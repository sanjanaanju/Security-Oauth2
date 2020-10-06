package com.project.Entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.*;

@Entity
public class Role extends BaseIdEntity {
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="permission_role",joinColumns= {
			@JoinColumn(name="role_id",referencedColumnName="id")},inverseJoinColumns= {
					@JoinColumn(name="permission_id",referencedColumnName="id")})
private List<Permission> permissions;
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
}
