package train.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Post entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "post", catalog = "netesp")
public class Post implements java.io.Serializable {

	// Fields

	private Long postId;
	private User user;
	private Thread thread;
	private String content;
	private Timestamp createDate;
	private Boolean isCream;
	private Boolean isReview;
	private String reviewer;
	private String reviewResult;
	private Set<Postcomment> postcomments = new HashSet<Postcomment>(0);

	// Constructors

	/** default constructor */
	public Post() {
	}

	/** minimal constructor */
	public Post(Long postId, User user, Thread thread, String content,
			Timestamp createDate, Boolean isReview) {
		this.postId = postId;
		this.user = user;
		this.thread = thread;
		this.content = content;
		this.createDate = createDate;
		this.isReview = isReview;
	}

	/** full constructor */
	public Post(Long postId, User user, Thread thread, String content,
			Timestamp createDate, Boolean isCream, Boolean isReview,
			String reviewer, String reviewResult, Set<Postcomment> postcomments) {
		this.postId = postId;
		this.user = user;
		this.thread = thread;
		this.content = content;
		this.createDate = createDate;
		this.isCream = isCream;
		this.isReview = isReview;
		this.reviewer = reviewer;
		this.reviewResult = reviewResult;
		this.postcomments = postcomments;
	}

	// Property accessors
	@Id
	@Column(name = "post_id", unique = true, nullable = false)
	public Long getPostId() {
		return this.postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
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
	@JoinColumn(name = "thread_id", nullable = false)
	public Thread getThread() {
		return this.thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	@Column(name = "content", nullable = false, length = 1000)
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

	@Column(name = "is_cream")
	public Boolean getIsCream() {
		return this.isCream;
	}

	public void setIsCream(Boolean isCream) {
		this.isCream = isCream;
	}

	@Column(name = "is_review", nullable = false)
	public Boolean getIsReview() {
		return this.isReview;
	}

	public void setIsReview(Boolean isReview) {
		this.isReview = isReview;
	}

	@Column(name = "reviewer", length = 20)
	public String getReviewer() {
		return this.reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	@Column(name = "review_result", length = 10)
	public String getReviewResult() {
		return this.reviewResult;
	}

	public void setReviewResult(String reviewResult) {
		this.reviewResult = reviewResult;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "post")
	public Set<Postcomment> getPostcomments() {
		return this.postcomments;
	}

	public void setPostcomments(Set<Postcomment> postcomments) {
		this.postcomments = postcomments;
	}

}