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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="store")
public class Store implements Serializable{
	
	private static final long serialVersionUID = -4075553995622101333L;

	public Store() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer storeId;
	
	//@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	//@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="manager_staff_id")
	private Staff staff;
	
	@JsonBackReference("inventory")
	@OneToMany(mappedBy="store",cascade=CascadeType.ALL)
	private List<Inventory> inventory;
	
	@JsonBackReference("customer")
	@OneToMany(mappedBy="store",cascade=CascadeType.ALL)
	private List<Customer> customer;
	
	@JsonBackReference("staffList")
	@OneToMany(mappedBy="store",cascade=CascadeType.ALL)
	private List<Staff> listStaff;
	
	@JsonIgnore
	@Column(name="last_update")
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date lastUpdate;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public List<Inventory> getInventory() {
		return inventory;
	}

	public void setInventory(List<Inventory> inventory) {
		this.inventory = inventory;
	}

	public List<Staff> getListStaff() {
		return listStaff;
	}

	public void setListStaff(List<Staff> listStaff) {
		this.listStaff = listStaff;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Customer> getCustomer() {
		return customer;
	}

	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
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
		return "Store [storeId=" + storeId + ", address=" + address + ", staff=" + staff + ", inventory=" + inventory
				+ ", customer=" + customer + ", listStaff=" + listStaff + ", lastUpdate=" + lastUpdate + "]";
	}

}
