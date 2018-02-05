package com.bg.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="city")
public class City implements Serializable{
	
	private static final long serialVersionUID = 4743672241667258581L;

	public City() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer cityId;
	
	@Column(name="city")
	@NotNull
	@Size(max=50)
	private String city;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="country_id")
	private Country country;
	
	@JsonIgnore
	@Column(name="last_update")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date lastUpdate;

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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
		return "City [cityId=" + cityId + ", city=" + city + ", country=" + country + ", lastUpdate=" + lastUpdate
				+ "]";
	}
	
}
