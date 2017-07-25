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
 * Repositorycategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "repositorycategory", catalog = "netesp")
public class Repositorycategory implements java.io.Serializable {

	// Fields

	private Long categoryId;
	private User user;
	private String name;
	private Long parentId;
	private String displayOrder;
	private String note;
	private Boolean isReview;
	private String reviewer;
	private String reviewResult;
	private Set<Knowledge> knowledges = new HashSet<Knowledge>(0);

	// Constructors

	/** default constructor */
	public Repositorycategory() {
	}

	/** minimal constructor */
	public Repositorycategory(Long categoryId, User user, String name,
			Long parentId, String displayOrder, Boolean isReview) {
		this.categoryId = categoryId;
		this.user = user;
		this.name = name;
		this.parentId = parentId;
		this.displayOrder = displayOrder;
		this.isReview = isReview;
	}

	/** full constructor */
	public Repositorycategory(Long categoryId, User user, String name,
			Long parentId, String displayOrder, String note, Boolean isReview,
			String reviewer, String reviewResult, Set<Knowledge> knowledges) {
		this.categoryId = categoryId;
		this.user = user;
		this.name = name;
		this.parentId = parentId;
		this.displayOrder = displayOrder;
		this.note = note;
		this.isReview = isReview;
		this.reviewer = reviewer;
		this.reviewResult = reviewResult;
		this.knowledges = knowledges;
	}

	// Property accessors
	@Id
	@Column(name = "category_id", unique = true, nullable = false)
	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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

	@Column(name = "parent_id")
	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@Column(name = "display_order", nullable = false, length = 20)
	public String getDisplayOrder() {
		return this.displayOrder;
	}

	public void setDisplayOrder(String displayOrder) {
		this.displayOrder = displayOrder;
	}

	@Column(name = "note", length = 100)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "repositorycategory")
	public Set<Knowledge> getKnowledges() {
		return this.knowledges;
	}

	public void setKnowledges(Set<Knowledge> knowledges) {
		this.knowledges = knowledges;
	}

	@Override
	public String toString() {
		return "Repositorycategory{" +
				"categoryId=" + categoryId +
				", user=" + user +
				", name='" + name + '\'' +
				", parentId=" + parentId +
				", displayOrder='" + displayOrder + '\'' +
				", note='" + note + '\'' +
				", isReview=" + isReview +
				", reviewer='" + reviewer + '\'' +
				", reviewResult='" + reviewResult + '\'' +
				", knowledges=" + knowledges +
				'}';
	}
}