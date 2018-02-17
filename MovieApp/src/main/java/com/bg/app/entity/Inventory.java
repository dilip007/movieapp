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
@Table(name="inventory")
public class Inventory implements Serializable{

	private static final long serialVersionUID = 3394384382445618756L;

	public Inventory() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer inventory_id;

	//@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="store_id")
	private Store store;
	
	//@JsonManagedReference
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="film_id")
	private Film film;
	
	@JsonBackReference
	@OneToMany(mappedBy="inventory",cascade=CascadeType.ALL)
	private List<Rental> rental;

	@JsonIgnore
	@Column(name="last_update")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date lastUpdate;

	public Integer getInventory_id() {
		return inventory_id;
	}

	public void setInventory_id(Integer inventory_id) {
		this.inventory_id = inventory_id;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public List<Rental> getRental() {
		return rental;
	}

	public void setRental(List<Rental> rental) {
		this.rental = rental;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
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
		return "Inventory [inventory_id=" + inventory_id + ", store=" + store + ", film=" + film + ", rental=" + rental
				+ ", lastUpdate=" + lastUpdate + "]";
	}
}
