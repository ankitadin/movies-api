package com.movie.api.movieservice;

import java.util.List;

import com.movie.api.model.Movie;

public interface MovieService {

	public List<Movie> getAllMovie();

	public Movie saveMovie(Movie m);

	public List<Movie> findByyear(String year);

	public List<Movie> findByrating(String year);
}
