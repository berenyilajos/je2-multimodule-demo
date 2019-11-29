package com.example.common.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Entity {
	@Id
	@Column(name = "id")
	@GeneratedValue
	private long id;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

}
