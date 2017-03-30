package com.broodcamp.model;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AuditableEntity extends BaseEntity {

	private static final long serialVersionUID = -7396287688163517308L;

	@Embedded
	private Auditable auditable;

	public Auditable getAuditable() {
		return auditable;
	}

	public void setAuditable(Auditable auditable) {
		this.auditable = auditable;
	}

}
