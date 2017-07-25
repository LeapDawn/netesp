package train.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ExamQuestionId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ExamQuestionId implements java.io.Serializable {

	// Fields

	private Long examId;
	private Long questionId;

	// Constructors

	/** default constructor */
	public ExamQuestionId() {
	}

	/** full constructor */
	public ExamQuestionId(Long examId, Long questionId) {
		this.examId = examId;
		this.questionId = questionId;
	}

	// Property accessors

	@Column(name = "exam_id", nullable = false)
	public Long getExamId() {
		return this.examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	@Column(name = "question_id", nullable = false)
	public Long getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ExamQuestionId))
			return false;
		ExamQuestionId castOther = (ExamQuestionId) other;

		return ((this.getExamId() == castOther.getExamId()) || (this
				.getExamId() != null && castOther.getExamId() != null && this
				.getExamId().equals(castOther.getExamId())))
				&& ((this.getQuestionId() == castOther.getQuestionId()) || (this
						.getQuestionId() != null
						&& castOther.getQuestionId() != null && this
						.getQuestionId().equals(castOther.getQuestionId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getExamId() == null ? 0 : this.getExamId().hashCode());
		result = 37
				* result
				+ (getQuestionId() == null ? 0 : this.getQuestionId()
						.hashCode());
		return result;
	}

}