package com.bg.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="category")
public class Category implements Serializable{
	
	private static final long serialVersionUID = 1287580247409439145L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer category_id;
	
	@Column(name="name")
	@Size(max=25)
	@NotNull
	private String name;
	
	@JsonIgnore
	@Column(name="last_update")
	@NotNull
	private Date lastUpdate;

	public Integer getCategoryId() {
		return category_id;
	}

	public void setCategoryId(Integer categoryId) {
		this.category_id = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	@PrePersist
	@PreUpdate
	public void saveOrUpdate() {
		this.setLastUpdate(new Date());
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + category_id + ", name=" + name + ", lastUpdate=" + lastUpdate + "]";
	}
	
}