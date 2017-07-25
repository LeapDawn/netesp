package train.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ExamQuestion entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "exam_question", catalog = "netesp")
public class ExamQuestion implements java.io.Serializable {

	// Fields

	private ExamQuestionId id;
	private Question question;
	private Exam exam;

	// Constructors

	/** default constructor */
	public ExamQuestion() {
	}

	/** full constructor */
	public ExamQuestion(ExamQuestionId id, Question question, Exam exam) {
		this.id = id;
		this.question = question;
		this.exam = exam;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "examId", column = @Column(name = "exam_id", nullable = false)),
			@AttributeOverride(name = "questionId", column = @Column(name = "question_id", nullable = false)) })
	public ExamQuestionId getId() {
		return this.id;
	}

	public void setId(ExamQuestionId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id", nullable = false, insertable = false, updatable = false)
	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exam_id", nullable = false, insertable = false, updatable = false)
	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

}