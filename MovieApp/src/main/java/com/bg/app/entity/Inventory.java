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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="inventory")
public class Inventory {

	public Inventory() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer inventory_id;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="store_id")
	private Store store;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="film_id")
	private Film film;

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
		return "Inventory [inventory_id=" + inventory_id + ", store=" + store + ", film=" + film + ", lastUpdate="
				+ lastUpdate + "]";
	}
	
}
