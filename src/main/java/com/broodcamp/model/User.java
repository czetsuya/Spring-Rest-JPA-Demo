package com.broodcamp.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "msc_user")
public class User extends AuditableEntity {

	private static final long serialVersionUID = -162968643877845902L;

	@Column(name = "FIRST_NAME", length = 50)
	@Size(max = 50)
	@NotNull
	private String firstName;

	@Column(name = "LAST_NAME", length = 50)
	@Size(max = 50)
	@NotNull
	private String lastName;

	@Column(name = "EMAIL", length = 75)
	@Size(max = 75)
	@NotNull
	private String email;

	@Column(name = "COMPANY", length = 100)
	@Size(max = 100)
	private String company;

	@Column(name = "PASSWORD", length = 125)
	@Size(max = 125)
	private String password;

	@Column(name = "STATUS", length = 15)
	@Size(max = 15)
	private String status;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "MSC_MAP_USER_ROLE", joinColumns = @JoinColumn(name = "USER_ID"), inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private Set<Role> roles = new HashSet<>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
