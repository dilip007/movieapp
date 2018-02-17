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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="payment")
public class Payment implements Serializable{

	private static final long serialVersionUID = -6428753962954434431L;

	public Payment() {
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer payment_id;
	
	//@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	//@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="rental_id")
	private Rental rental;

	//@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="staff_id")
	private Staff staff;
	
	@Column(name="amount")
	@NotNull
	private Float amount;
	
	@Column(name="payment_date",columnDefinition="DATETIME")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date paymentDate;
	
	@JsonIgnore
	@Column(name="last_update")
	@NotNull
	private Date lastUpdate;

	public Integer getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(Integer payment_id) {
		this.payment_id = payment_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Rental getRental() {
		return rental;
	}

	public void setRental(Rental rental) {
		this.rental = rental;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
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
		this.setPaymentDate(new Date());
	}

	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", customer=" + customer + ", rental=" + rental + ", staff="
				+ staff + ", amount=" + amount + ", paymentDate=" + paymentDate + ", lastUpdate=" + lastUpdate + "]";
	}

}
