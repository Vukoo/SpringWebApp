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
//	 @Query(value="INSERT INTO Comment(body,current_date, title,user_id,movie_id) VALUES (:body,CURDATE(),:userd,:movieId) ",nativeQuery = true)
//	  List<Comment> saveComment(String body,String title, Long userId, Long movieId);
}
