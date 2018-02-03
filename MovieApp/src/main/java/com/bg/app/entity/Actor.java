package com.bg.app.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="actor")
public class Actor {
	
	public Actor() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer actor_id;
	
    @Column(name="first_name")
    @Size(max=45)
    @NotNull
	private String firstName;
    
    @Column(name="last_name")
    @Size(max=45)
    @NotNull
    private String lastName;
	
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="film_actor",
    joinColumns= {@JoinColumn(name="actor_id")},
    inverseJoinColumns= {@JoinColumn(name="film_id")})
    private List<Film> filmList;
    
    @Column(name="last_update")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;

	public Integer getActorId() {
		return actor_id;
	}

	public void setActorId(Integer actorId) {
		this.actor_id = actorId;
	}

	public List<Film> getFilmList() {
		return filmList;
	}

	public void setFilmList(List<Film> filmList) {
		this.filmList = filmList;
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
		return "Actor [actorId=" + actor_id + ", firstName=" + firstName + ", lastName=" + lastName + ", lastUpdate="
				+ lastUpdate + "]";
	}
    
}
