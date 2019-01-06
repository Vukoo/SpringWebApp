package org.gadek.repository;

import org.gadek.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
