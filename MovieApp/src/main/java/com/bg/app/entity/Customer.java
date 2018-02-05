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
@Table(name="customer")
public class Customer implements Serializable{

	private static final long serialVersionUID = 5977805169496137689L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer customerId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="store_id")
	private Store store;
	
	@Column(name="first_name")
	@Size(max=45)
	@NotNull
	private String firstName;

	@Column(name="last_name")
	@Size(max=45)
	@NotNull
	private String lastName;
	
	@Column(name="email")
	@Size(max=50)
	private String email;
	
	@Column(name="active")
	@NotNull
	private Integer active;
	
	@JsonIgnore
	@Column(name="create_date",columnDefinition="DATETIME")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@JsonIgnore
	@Column(name="last_update")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date lastUpdate;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

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

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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
		return "Customer [customerId=" + customerId + ", address=" + address + ", store=" + store + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", active=" + active + ", createDate="
				+ createDate + ", lastUpdate=" + lastUpdate + "]";
	}
}
