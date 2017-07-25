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
 * Question entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "question", catalog = "netesp")
public class Question implements java.io.Serializable {

	// Fields

	private Long questionId;
	private Questiondifficulty questiondifficulty;
	private Questioncategory questioncategory;
	private String type;
	private String pattern;
	private String content;
	private String answer;
	private Boolean isReview;
	private String reviewer;
	private String reviewResult;
	private Set<ExamQuestion> examQuestions = new HashSet<ExamQuestion>(0);

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** minimal constructor */
	public Question(Long questionId, Questiondifficulty questiondifficulty,
			Questioncategory questioncategory, String type, String pattern,
			String content, String answer, Boolean isReview) {
		this.questionId = questionId;
		this.questiondifficulty = questiondifficulty;
		this.questioncategory = questioncategory;
		this.type = type;
		this.pattern = pattern;
		this.content = content;
		this.answer = answer;
		this.isReview = isReview;
	}

	/** full constructor */
	public Question(Long questionId, Questiondifficulty questiondifficulty,
			Questioncategory questioncategory, String type, String pattern,
			String content, String answer, Boolean isReview, String reviewer,
			String reviewResult, Set<ExamQuestion> examQuestions) {
		this.questionId = questionId;
		this.questiondifficulty = questiondifficulty;
		this.questioncategory = questioncategory;
		this.type = type;
		this.pattern = pattern;
		this.content = content;
		this.answer = answer;
		this.isReview = isReview;
		this.reviewer = reviewer;
		this.reviewResult = reviewResult;
		this.examQuestions = examQuestions;
	}

	// Property accessors
	@Id
	@Column(name = "question_id", unique = true, nullable = false)
	public Long getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "difficulty_id", nullable = false)
	public Questiondifficulty getQuestiondifficulty() {
		return this.questiondifficulty;
	}

	public void setQuestiondifficulty(Questiondifficulty questiondifficulty) {
		this.questiondifficulty = questiondifficulty;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Questioncategory getQuestioncategory() {
		return this.questioncategory;
	}

	public void setQuestioncategory(Questioncategory questioncategory) {
		this.questioncategory = questioncategory;
	}

	@Column(name = "type", nullable = false, length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "pattern", nullable = false, length = 100)
	public String getPattern() {
		return this.pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	@Column(name = "content", nullable = false, length = 5000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "answer", nullable = false, length = 1000)
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "question")
	public Set<ExamQuestion> getExamQuestions() {
		return this.examQuestions;
	}

	public void setExamQuestions(Set<ExamQuestion> examQuestions) {
		this.examQuestions = examQuestions;
	}

}