package com.movie.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movie.api.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	public List<Movie> findByyear(String year);

	public Movie findBymname(String mname);

	public List<Movie> findByrating(String rating);

}
