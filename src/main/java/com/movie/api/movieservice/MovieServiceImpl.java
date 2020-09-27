package com.movie.api.movieservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.api.model.Movie;
import com.movie.api.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository m;

	public List<Movie> getAllMovie() {
		List<Movie> movie = new ArrayList<Movie>();
		m.findAll().forEach(moviei -> movie.add(moviei));
		return movie;
	}

	@Override
	public Movie saveMovie(Movie mm) {
		// TODO Auto-generated method stub
		return m.save(mm);
	}

	@Override
	public List<Movie> findByyear(String year) {
		// TODO Auto-generated method stub
		List<Movie> list = m.findByyear(year);
		return list;
	}

	@Override
	public List<Movie> findByrating(String year) {
		// TODO Auto-generated method stub
		List<Movie> list = m.findByrating(year);
		return list;
	}

}
