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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="staff")
public class Staff implements Serializable{

	private static final long serialVersionUID = -9130946658793355218L;

	public Staff() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer staff_id;
	
	@Column(name="first_name")
    @Size(max=45)
    @NotNull
	private String firstName;
    
    @Column(name="last_name")
    @Size(max=45)
    @NotNull
    private String lastName;
    
    //@JsonManagedReference
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="address_id")
    private Address address;
    
    //@JsonManagedReference
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="store_id")
    private Store store;
    
    @JsonBackReference("store")
    @OneToMany(mappedBy="staff",cascade=CascadeType.ALL)
    private List<Store> storeList;
    
    @JsonBackReference("rental")
    @OneToMany(mappedBy="staff",cascade=CascadeType.ALL)
    private List<Rental> rental;

    @JsonBackReference("payment")
    @OneToMany(mappedBy="staff",cascade=CascadeType.ALL)
    private List<Payment> payment;
    
    @Column(name="email")
    @Size(max=50)
    private String email;
    
    @Column(name="active")
    @Size(max=1)
    @NotNull
    private Integer active;
    
    @Column(name="username")
    @Size(max=16)
    @NotNull
    private String username;
    
    @Column(name="password")
    @Size(max=40)
    @NotNull
    private String password;
    
    @JsonIgnore
    @Column(name="last_update")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;

	public Integer getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Integer staff_id) {
		this.staff_id = staff_id;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@JsonIgnore
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<Store> getStoreList() {
		return storeList;
	}

	public void setStoreList(List<Store> storeList) {
		this.storeList = storeList;
	}

	@JsonIgnore
	public List<Rental> getRental() {
		return rental;
	}

	public void setRental(List<Rental> rental) {
		this.rental = rental;
	}

	@JsonIgnore
	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Staff [staff_id=" + staff_id + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", store=" + store + ", storeList=" + storeList + ", rental=" + rental + ", payment="
				+ payment + ", email=" + email + ", active=" + active + ", username=" + username + ", password="
				+ password + ", lastUpdate=" + lastUpdate + "]";
	}

}
