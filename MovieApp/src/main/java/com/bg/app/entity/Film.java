package com.bg.app.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityResult;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="film")
@SqlResultSetMapping(
	    name = "implicit", entities =
	    @EntityResult(entityClass = Film.class)
	)
@NamedNativeQueries({
	@NamedNativeQuery(
			name="Film.getMovieListByActorId",
			query="SELECT * FROM film f WHERE f.film_id IN(SELECT fa.film_id FROM film_actor fa where fa.actor_id=?)",
			resultSetMapping="implicit"
			)
})
public class Film implements Serializable{

	private static final long serialVersionUID = 1364419698353096917L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="film_id")
	private Integer film_id;
	
	@Column(name="title",length=255)
    //@Size(max=255)
    @NotNull
	private String title;
    
    @Column(name="description")
    private String description;
    
    @Column(name="release_year",length=11)
    //@Size(max=11)
	private Integer releaseYear;
    
    //@JsonManagedReference
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="language_id")
    private Language language;
    
    //@JsonManagedReference
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="original_language_id")
    private Language originalLanguageId;
    
    @JsonBackReference(value="categoryList")
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="film_category",
    joinColumns= {@JoinColumn(name="film_id")},
    inverseJoinColumns= {@JoinColumn(name="category_id")})
    private List<Category> category = new ArrayList<>();
    
    //@JsonManagedReference
    @ManyToMany(mappedBy="filmList",cascade=CascadeType.ALL)
    private List<Actor> actorsList = new ArrayList<>();
    
    @JsonBackReference(value="inventoryList")
    @OneToMany(mappedBy="film",cascade=CascadeType.ALL)
    private List<Inventory> inventoryList;
    
    @Column(name="rental_duration")
    //@NotNull
    private Integer rentalDuration;
    
    @Column(name="rental_rate")
    //@NotNull
    private Float rentalRate;
    
    @Column(name="length",length=5)
    //@Size(max=5)
    private Integer length;
    
    @Column(name="replacement_cost")
    //@NotNull
    private Float replacementCost;
    
    @Column(name="rating",length=20)
    //@Size(max=20)
    private String rating;
    
    @Column(name="special_features",length=100)
    //@Size(max=100)
    private String special_features;
	
    @JsonIgnore
    @Column(name="last_update")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;

	public Integer getFilm_id() {
		return film_id;
	}

	public void setFilm_id(Integer film_id) {
		this.film_id = film_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Actor> getActorsList() {
		return actorsList;
	}

	public void setActorsList(List<Actor> actorsList) {
		this.actorsList = actorsList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Inventory> getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(List<Inventory> inventoryList) {
		this.inventoryList = inventoryList;
	}

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Language getOriginalLanguageId() {
		return originalLanguageId;
	}

	public void setOriginalLanguageId(Language originalLanguageId) {
		this.originalLanguageId = originalLanguageId;
	}

	public Integer getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Integer rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public Float getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(Float rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Float getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(Float replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
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
		return "Film [film_id=" + film_id + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", language=" + language + ", originalLanguageId=" + originalLanguageId
				+ ", categoryList=" + category + ", actorsList=" + actorsList + ", inventoryList=" + inventoryList
				+ ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length
				+ ", replacementCost=" + replacementCost + ", rating=" + rating + ", special_features="
				+ special_features + ", lastUpdate=" + lastUpdate + "]";
	}

}
