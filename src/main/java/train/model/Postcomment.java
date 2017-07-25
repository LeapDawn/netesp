package train.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Postcomment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "postcomment", catalog = "netesp")
public class Postcomment implements java.io.Serializable {

	// Fields

	private Long commentId;
	private User user;
	private Post post;
	private String content;
	private Timestamp createDate;

	// Constructors

	/** default constructor */
	public Postcomment() {
	}

	/** full constructor */
	public Postcomment(Long commentId, User user, Post post, String content,
			Timestamp createDate) {
		this.commentId = commentId;
		this.user = user;
		this.post = post;
		this.content = content;
		this.createDate = createDate;
	}

	// Property accessors
	@Id
	@Column(name = "comment_id", unique = true, nullable = false)
	public Long getCommentId() {
		return this.commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id", nullable = false)
	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	@Column(name = "content", nullable = false, length = 500)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "create_date", nullable = false, length = 19)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}