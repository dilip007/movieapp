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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="address")
public class Address implements Serializable{
	
	private static final long serialVersionUID = 909143862225297888L;

	public Address() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer address_id;
	
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
	
	//@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	private City city;
	
	@JsonBackReference("customer")
	@OneToMany(mappedBy="address",cascade=CascadeType.ALL)
	private List<Customer> customer;
	
	@JsonBackReference("store")
	@OneToMany(mappedBy="address",cascade=CascadeType.ALL)
	private List<Store> store;
	
	@JsonBackReference("staff")
	@OneToMany(mappedBy="address",cascade=CascadeType.ALL)
	private List<Staff> staff;
	
	@Column(name="postal_code")
	@Size(max=10)
	private String postalCode;
	
	@Column(name="phone")
	@Size(max=20)
	@NotNull
	private String phone;
	
	@JsonIgnore
	@Column(name="last_update")
	@Temporal(TemporalType.DATE)
	private Date lastUpdate;

	public Integer getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Integer address_id) {
		this.address_id = address_id;
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

	public List<Store> getStore() {
		return store;
	}

	public void setStore(List<Store> store) {
		this.store = store;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
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

	@PrePersist
	@PreUpdate
	public void saveOrUpdate() {
		this.setLastUpdate(new Date());
	}

	@Override
	public String toString() {
		return "Address [address_id=" + address_id + ", address=" + address + ", address2=" + address2 + ", district="
				+ district + ", city=" + city + ", customer=" + customer + ", store=" + store + ", staff=" + staff
				+ ", postalCode=" + postalCode + ", phone=" + phone + ", lastUpdate=" + lastUpdate + "]";
	}

}
