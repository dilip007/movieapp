package com.bg.app.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="address")
public class Address {
	
	public Address() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer addressID;
	
	@Column(name="address")
	@Size(max=50)
	@NotNull
	private String address;
	
	@Column(name="address2")
	@Size(max=50)
	private String address2;
	
	@Column(name="district")
	@Size(max=20)
	@NotNull
	private String district;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	private City city;
	
	@Column(name="postal_code")
	@Size(max=10)
	private String postalCode;
	
	@Column(name="phone")
	@Size(max=20)
	@NotNull
	private String phone;
	
	@Column(name="last_update")
	@Temporal(TemporalType.DATE)
	private Date lastUpdate;

	public Integer getAddressID() {
		return addressID;
	}

	public void setAddressID(Integer addressID) {
		this.addressID = addressID;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	@Override
	public String toString() {
		return "Address [addressID=" + addressID + ", address=" + address + ", address2=" + address2 + ", district="
				+ district + ", city=" + city + ", postalCode=" + postalCode + ", phone=" + phone + ", lastUpdate="
				+ lastUpdate + "]";
	}

}
