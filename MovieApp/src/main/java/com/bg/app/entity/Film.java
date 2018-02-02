/*package com.bg.app.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="film")
public class Film {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer filmId;
	
	@Column(name="title")
    @Size(max=255)
    @NotNull
	private String title;
    
    @Column(name="description")
    private String description;
    
    @Column(name="release_year")
    @Size(max=11)
	private Integer releaseYear;
    
    @Column(name="original_language_id")
    @Size(max=3)
    private Integer originalLanguageId;
    
    //languageId
    
    @Column(name="rental_duration")
    @NotNull
    private Integer rentalDuration;
    
    @Column(name="rental_rate")
    @NotNull
    private Float rentalRate;
    
    @Column(name="length")
    @Size(max=5)
    @NotNull
    private Integer length;
    
    @Column(name="replacement_cost")
    @NotNull
    private Float replacementCost;
    
    @Column(name="rating")
    @Size(max=20)
    private String rating;
    
    @Column(name="special_features")
    @Size(max=100)
    private String special_features;
	
    @Column(name="last_update")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;

	public Integer getFilmId() {
		return filmId;
	}

	public void setFilmId(Integer filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public Integer getOriginalLanguageId() {
		return originalLanguageId;
	}

	public void setOriginalLanguageId(Integer originalLanguageId) {
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

    
	
	
}
*/