package com.bg.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

	@JsonManagedReference
	@ManyToMany(mappedBy="category")
	private List<Film> filmList;

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
	
	public List<Film> getFilmList() {
		return filmList;
	}

	public void setFilmList(List<Film> filmList) {
		this.filmList = filmList;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	@PrePersist
	@PreUpdate
	public void saveOrUpdate() {
		this.setLastUpdate(new Date());
	}

	@Override
	public String toString() {
		return "Category [category_id=" + category_id + ", name=" + name + ", lastUpdate=" + lastUpdate
				+ ", categoryList=" + filmList + "]";
	}

}