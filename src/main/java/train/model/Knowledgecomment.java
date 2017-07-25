package train.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Knowledgecomment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knowledgecomment", catalog = "netesp")
public class Knowledgecomment implements java.io.Serializable {

	// Fields

	private Long commentId;
	private Knowledge knowledge;
	private User user;
	private String content;
	private Date createDate;
	private Boolean isReview;
	private String reviewer;
	private String reviewResult;

	// Constructors

	/** default constructor */
	public Knowledgecomment() {
	}

	/** minimal constructor */
	public Knowledgecomment(Long commentId, Knowledge knowledge, User user,
			String content, Date createDate, Boolean isReview) {
		this.commentId = commentId;
		this.knowledge = knowledge;
		this.user = user;
		this.content = content;
		this.createDate = createDate;
		this.isReview = isReview;
	}

	/** full constructor */
	public Knowledgecomment(Long commentId, Knowledge knowledge, User user,
			String content, Date createDate, Boolean isReview, String reviewer,
			String reviewResult) {
		this.commentId = commentId;
		this.knowledge = knowledge;
		this.user = user;
		this.content = content;
		this.createDate = createDate;
		this.isReview = isReview;
		this.reviewer = reviewer;
		this.reviewResult = reviewResult;
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
	@JoinColumn(name = "knowledge_id", nullable = false)
	public Knowledge getKnowledge() {
		return this.knowledge;
	}

	public void setKnowledge(Knowledge knowledge) {
		this.knowledge = knowledge;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "content", nullable = false, length = 1000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "create_date", nullable = false, length = 10)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
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

}