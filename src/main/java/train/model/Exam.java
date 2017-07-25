package train.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Exam entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "exam", catalog = "netesp")
public class Exam implements java.io.Serializable {

	// Fields

	private Long examId;
	private String name;
	private Set<ExamQuestion> examQuestions = new HashSet<ExamQuestion>(0);
	private Set<Practice> practices = new HashSet<Practice>(0);

	// Constructors

	/** default constructor */
	public Exam() {
	}

	/** minimal constructor */
	public Exam(Long examId, String name) {
		this.examId = examId;
		this.name = name;
	}

	/** full constructor */
	public Exam(Long examId, String name, Set<ExamQuestion> examQuestions,
			Set<Practice> practices) {
		this.examId = examId;
		this.name = name;
		this.examQuestions = examQuestions;
		this.practices = practices;
	}

	// Property accessors
	@Id
	@Column(name = "exam_id", unique = true, nullable = false)
	public Long getExamId() {
		return this.examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exam")
	public Set<ExamQuestion> getExamQuestions() {
		return this.examQuestions;
	}

	public void setExamQuestions(Set<ExamQuestion> examQuestions) {
		this.examQuestions = examQuestions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "exam")
	public Set<Practice> getPractices() {
		return this.practices;
	}

	public void setPractices(Set<Practice> practices) {
		this.practices = practices;
	}

}