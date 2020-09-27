package com.movie.api.movieservice;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.movie.api.model.Movie;
import com.movie.api.repository.MovieRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieServiceImplTest {
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	MovieRepository resp;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void saveMovieTest() {
		Movie msave = resp.save(new Movie("ddlj", "2020", "1"));

		assertThat(msave).hasFieldOrPropertyWithValue("mname", "ddlj");
		assertThat(msave).hasFieldOrPropertyWithValue("year", "2020");
		assertThat(msave).hasFieldOrPropertyWithValue("rating", "1");
	}

	@Test
	public void testGetAllMovie() {
		// fail("Not yet implemented");
		Movie t1 = new Movie("raja", "91", "4");
		entityManager.persist(t1);

		Movie t2 = new Movie("panga", "92", "2");
		entityManager.persist(t2);

		Movie t3 = new Movie("bharat", "93", "5");
		entityManager.persist(t3);
		Iterable<Movie> tm = resp.findAll();
		assertThat(tm).hasSize(3).contains(t1, t2, t3);

	}

	@Test
	public void testgetMovieByYear() {
		// fail("Not yet implemented");
		Movie t1 = new Movie("raja", "91", "4");
		entityManager.persist(t1);

		Movie t2 = new Movie("panga", "92", "2");
		entityManager.persist(t2);

		Movie t3 = new Movie("bharat", "93", "5");
		entityManager.persist(t3);

		Iterable<Movie> tm = resp.findByyear("92");

		assertThat(tm).hasSize(1).contains(t2);

	}

	@Test
	public void testgetMovieByRating() {
		// fail("Not yet implemented");
		Movie t1 = new Movie("raja", "91", "4");
		entityManager.persist(t1);

		Movie t2 = new Movie("panga", "92", "2");
		entityManager.persist(t2);

		Movie t3 = new Movie("bharat", "93", "5");
		entityManager.persist(t3);

		Iterable<Movie> tm = resp.findByrating("4");

		assertThat(tm).hasSize(1).contains(t1);

	}

}
