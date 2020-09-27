package com.movie.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "mname")
	private String mname;
	@Column(name = "year")
	private String year;
	@Column(name = "rating")
	private String rating;

	public Movie() {
		super();
	}

	public Movie(String mname, String year, String rating) {
		this.mname = mname;
		this.year = year;
		this.rating = rating;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public long getId() {
		return id;
	}

	public void setId(long mid) {
		this.id = mid;
	}

}
