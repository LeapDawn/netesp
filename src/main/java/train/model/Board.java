package train.model;

import java.lang.*;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * Board entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "board", catalog = "netesp")
public class Board implements java.io.Serializable {

	// Fields

	private Long boardId;
	private User user;
	private String name;
	private Date createDate;
	private Long boardMasterId;
	private Boolean isReview;
	private String reviewer;
	private String reviewResult;
	private Set<Thread> threads = new HashSet<Thread>(0);

	// Constructors

	/** default constructor */
	public Board() {
	}

	/** minimal constructor */
	public Board(Long boardId, User user, String name, Date createDate,
			Boolean isReview) {
		this.boardId = boardId;
		this.user = user;
		this.name = name;
		this.createDate = createDate;
		this.isReview = isReview;
	}

	/** full constructor */
	public Board(Long boardId, User user, String name, Date createDate,
			Long boardMasterId, Boolean isReview, String reviewer,
			String reviewResult, Set<Thread> threads) {
		this.boardId = boardId;
		this.user = user;
		this.name = name;
		this.createDate = createDate;
		this.boardMasterId = boardMasterId;
		this.isReview = isReview;
		this.reviewer = reviewer;
		this.reviewResult = reviewResult;
		this.threads = threads;
	}

	// Property accessors
	@Id
	@Column(name = "board_id", unique = true, nullable = false)
	public Long getBoardId() {
		return this.boardId;
	}

	public void setBoardId(Long boardId) {
		this.boardId = boardId;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date", nullable = false, length = 10)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "board_master_id")
	public Long getBoardMasterId() {
		return this.boardMasterId;
	}

	public void setBoardMasterId(Long boardMasterId) {
		this.boardMasterId = boardMasterId;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "board")
	public Set<Thread> getThreads() {
		return this.threads;
	}

	public void setThreads(Set<Thread> threads) {
		this.threads = threads;
	}

}