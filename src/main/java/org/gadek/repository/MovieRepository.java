package org.gadek.repository;

import org.gadek.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository("movieRepository")
public interface MovieRepository extends CrudRepository<Movie, Long> {
}
