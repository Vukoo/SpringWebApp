package org.gadek.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "comment")
public class Comment {
	@Id
    @GeneratedValue
	private Long commentId;
	private Long userId;
	private String title;
	private String body;
	private String commentDate;
	
	
	public Comment() {
		
	}
	
	public Comment(Long commentIid, Long userId, String title, String body, String commentDate) {
		super();
		this.commentId = commentIid;
		this.userId = userId;
		this.title = title;
		this.body = body;
		this.commentDate = commentDate;
	}
	
	
	public Long getCommentIid() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

}
