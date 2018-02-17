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
@Table(name="country")
public class Country implements Serializable{
	
	private static final long serialVersionUID = -1964877522627287299L;

	public Country() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer country_id;
	
	@Column(name="country")
	@NotNull
	@Size(max=50)
	private String country;
	
	@JsonBackReference
	@OneToMany(mappedBy="country",cascade=CascadeType.ALL)
	private List<City> city;
	
	@JsonIgnore
	@Column(name="last_update")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date lastUpdate;

	public Integer getCountry_id() {
		return country_id;
	}

	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<City> getCity() {
		return city;
	}

	public void setCity(List<City> city) {
		this.city = city;
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
		return "Country [countryId=" + country_id + ", country=" + country + ", city=" + city + ", lastUpdate="
				+ lastUpdate + "]";
	}
	
}
