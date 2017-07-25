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
 * Thread entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "thread", catalog = "netesp")
public class Thread implements java.io.Serializable {

	// Fields

	private Long threadId;
	private Board board;
	private User user;
	private String name;
	private String content;
	private Timestamp createDate;
	private Boolean isReview;
	private String reviewer;
	private String reviewResult;
	private Set<Post> posts = new HashSet<Post>(0);

	// Constructors

	/** default constructor */
	public Thread() {
	}

	/** minimal constructor */
	public Thread(Long threadId, Board board, User user, String name,
			String content, Timestamp createDate, Boolean isReview) {
		this.threadId = threadId;
		this.board = board;
		this.user = user;
		this.name = name;
		this.content = content;
		this.createDate = createDate;
		this.isReview = isReview;
	}

	/** full constructor */
	public Thread(Long threadId, Board board, User user, String name,
			String content, Timestamp createDate, Boolean isReview,
			String reviewer, String reviewResult, Set<Post> posts) {
		this.threadId = threadId;
		this.board = board;
		this.user = user;
		this.name = name;
		this.content = content;
		this.createDate = createDate;
		this.isReview = isReview;
		this.reviewer = reviewer;
		this.reviewResult = reviewResult;
		this.posts = posts;
	}

	// Property accessors
	@Id
	@Column(name = "thread_id", unique = true, nullable = false)
	public Long getThreadId() {
		return this.threadId;
	}

	public void setThreadId(Long threadId) {
		this.threadId = threadId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "board_id", nullable = false)
	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "content", nullable = false, length = 5000)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "thread")
	public Set<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

}