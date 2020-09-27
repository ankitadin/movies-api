package com.movie.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.movie.api.exception.MovieException;
import com.movie.api.model.Movie;
import com.movie.api.movieservice.MovieService;
import com.movie.api.repository.MovieRepository;

@RestController
@RequestMapping("/movie")
public class MovieController {
	@Autowired
	MovieRepository reps;

	@Autowired
	MovieService mservicee;

	// create movie
	@PostMapping("/movie")
	public Movie createMovie(@RequestBody Movie m) {
		System.out.println("jjj" + m.getMname());
		Movie mmovie = reps.save(m);
		return mmovie;
	}

	// update movie
	@PutMapping("/movie/{name}")
	public Movie updateMovie(@PathVariable(value = "name") String mname, @RequestBody Movie p) {
		Movie pp = reps.findBymname(mname);
		if (pp == null) {
			throw new MovieException("movie not found");
		}
		pp.setMname(p.getMname());
		pp.setYear(p.getYear());
		pp.setRating(p.getRating());

		return pp;
	}

	// all movie
	@GetMapping("/mall")
	private List<Movie> getAllMovie() {
		System.out.println("innnnn");

		return mservicee.getAllMovie();
	}

	// movie by year
	@GetMapping("/movie/{year}")
	public List<Movie> getMovieByYear(@PathVariable(value = "year") String id1) {
		System.out.println(" yr" + id1);
		List<Movie> list = mservicee.findByyear(id1);
		if (list == null) {
			throw new MovieException("movie not found");
		} else
			return list;

	}

	// movie by rating
	@GetMapping("/movier/{rating}")
	public List<Movie> getMovieByRating(@PathVariable(value = "rating") String id1) {
		System.out.println(" yr" + id1);
		List<Movie> list = mservicee.findByrating(id1);
		if (list == null) {
			throw new MovieException("movie not found");
		} else
			return list;

	}

}
