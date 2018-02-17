package com.bg.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="language")
public class Language implements Serializable{

	private static final long serialVersionUID = 2799779981955492169L;

	public Language() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer languageId;
	
	@Column(name="name",length=20)
	//@Size(max=20)
	@NotNull
	private String name;
	
	@JsonBackReference("filmList")
	@OneToMany(mappedBy="language",cascade=CascadeType.ALL)
	private List<Film> filmList;
	
	@JsonBackReference(value="originalLanguage")
	@OneToMany(mappedBy="originalLanguageId",cascade=CascadeType.ALL)
	private List<Film> originalLanguageFilmList;
	
	@JsonIgnore
	@Column(name="last_update")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;

	public Integer getLanguageId() {
		return languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Film> getFilmList() {
		return filmList;
	}

	public void setFilmList(List<Film> filmList) {
		this.filmList = filmList;
	}

	public List<Film> getOriginalLanguageFilmList() {
		return originalLanguageFilmList;
	}

	public void setOriginalLanguageFilmList(List<Film> originalLanguageFilmList) {
		this.originalLanguageFilmList = originalLanguageFilmList;
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
		return "Language [languageId=" + languageId + ", name=" + name + ", filmList=" + filmList
				+ ", originalLanguageFilmList=" + originalLanguageFilmList + ", lastUpdate=" + lastUpdate + "]";
	}

}
