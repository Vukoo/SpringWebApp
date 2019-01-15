package org.gadek.repository;

import java.util.List;

import org.gadek.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	 @Query(value="SELECT * FROM Comment t WHERE t.movie_id=:movieid ",nativeQuery = true)
	  List<Comment> findByMovieId(Long movieid);
}
