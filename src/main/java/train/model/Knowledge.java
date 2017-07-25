package train.model;

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
 * Knowledge entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "knowledge", catalog = "netesp")
public class Knowledge implements java.io.Serializable {

	// Fields

	private Long knowledgeId;
	private User user;
	private Repositorycategory repositorycategory;
	private String name;
	private String relativeData;
	private Boolean isReview;
	private String reviewer;
	private String reviewResult;
	private Set<Knowledgecomment> knowledgecomments = new HashSet<Knowledgecomment>(
			0);

	// Constructors

	/** default constructor */
	public Knowledge() {
	}

	/** minimal constructor */
	public Knowledge(Long knowledgeId, User user,
			Repositorycategory repositorycategory, String name,
			String relativeData, Boolean isReview) {
		this.knowledgeId = knowledgeId;
		this.user = user;
		this.repositorycategory = repositorycategory;
		this.name = name;
		this.relativeData = relativeData;
		this.isReview = isReview;
	}

	public Knowledge(Long knowledgeId, User user,
					 Repositorycategory repositorycategory, String name,
					 String relativeData, Boolean isReview, String reviewer,
					 String reviewResult) {
		this.knowledgeId = knowledgeId;
		this.user = user;
		this.repositorycategory = repositorycategory;
		this.name = name;
		this.relativeData = relativeData;
		this.isReview = isReview;
		this.reviewer = reviewer;
		this.reviewResult = reviewResult;
	}

	/** full constructor */
	public Knowledge(Long knowledgeId, User user,
			Repositorycategory repositorycategory, String name,
			String relativeData, Boolean isReview, String reviewer,
			String reviewResult, Set<Knowledgecomment> knowledgecomments) {
		this.knowledgeId = knowledgeId;
		this.user = user;
		this.repositorycategory = repositorycategory;
		this.name = name;
		this.relativeData = relativeData;
		this.isReview = isReview;
		this.reviewer = reviewer;
		this.reviewResult = reviewResult;
		this.knowledgecomments = knowledgecomments;
	}

	// Property accessors
	@Id
	@Column(name = "knowledge_id", unique = true, nullable = false)
	public Long getKnowledgeId() {
		return this.knowledgeId;
	}

	public void setKnowledgeId(Long knowledgeId) {
		this.knowledgeId = knowledgeId;
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
	@JoinColumn(name = "category_id", nullable = false)
	public Repositorycategory getRepositorycategory() {
		return this.repositorycategory;
	}

	public void setRepositorycategory(Repositorycategory repositorycategory) {
		this.repositorycategory = repositorycategory;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "relative_data", nullable = false, length = 5000)
	public String getRelativeData() {
		return this.relativeData;
	}

	public void setRelativeData(String relativeData) {
		this.relativeData = relativeData;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "knowledge")
	public Set<Knowledgecomment> getKnowledgecomments() {
		return this.knowledgecomments;
	}

	public void setKnowledgecomments(Set<Knowledgecomment> knowledgecomments) {
		this.knowledgecomments = knowledgecomments;
	}

	@Override
	public String toString() {
		return "Knowledge{" +
				"knowledgeId=" + knowledgeId +
				", user=" + user +
				", repositorycategory=" + repositorycategory +
				", name='" + name + '\'' +
				", relativeData='" + relativeData + '\'' +
				", isReview=" + isReview +
				", reviewer='" + reviewer + '\'' +
				", reviewResult='" + reviewResult + '\'' +
				", knowledgecomments=" + knowledgecomments +
				'}';
	}
}