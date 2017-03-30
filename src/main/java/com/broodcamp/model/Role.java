package com.broodcamp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "msc_role")
public class Role extends BaseEntity {

	private static final long serialVersionUID = 741945692932629381L;

	@Column(name = "name", length = 45)
	@NotNull
	@Size(max = 45)
	private String name;

	@Column(name = "description", length = 100)
	@NotNull
	@Size(max = 100)
	private String description;

	@Column(name = "status", length = 45)
	@NotNull
	@Size(max = 45)
	private String status;

	@Column(name = "role_is_default")
	private boolean isDefault;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isDefault() {
		return isDefault;
	}

	public void setDefault(boolean isDefault) {
		this.isDefault = isDefault;
	}

}
