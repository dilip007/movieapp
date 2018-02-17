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
@Table(name="rental")
public class Rental implements Serializable{
	
	private static final long serialVersionUID = 5107183526349576406L;

	public Rental() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer rental_id;
	
	@Column(name="rental_date",columnDefinition="DATETIME")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date rentalDate;
	
	//@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	//@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	@JsonBackReference
	@OneToMany(mappedBy="rental",cascade=CascadeType.ALL)
	private List<Payment> payment;
	
	//@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="inventory_id")
	private Inventory inventory;
	
	@Column(name="return_date",columnDefinition="DATETIME")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date returnDate;
	
	@JsonIgnore
	@Column(name="last_update")
	@NotNull
	private Date lastUpdate;

	public Integer getRental_id() {
		return rental_id;
	}

	public void setRental_id(Integer rental_id) {
		this.rental_id = rental_id;
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@JsonIgnore
	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@JsonIgnore
	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	@JsonIgnore
	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
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
		this.setRentalDate(new Date());
	}

	@Override
	public String toString() {
		return "Rental [rental_id=" + rental_id + ", rentalDate=" + rentalDate + ", customer=" + customer + ", staff="
				+ staff + ", payment=" + payment + ", inventory=" + inventory + ", returnDate=" + returnDate
				+ ", lastUpdate=" + lastUpdate + "]";
	}

}
