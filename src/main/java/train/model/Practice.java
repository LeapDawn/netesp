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
 * Practice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "practice", catalog = "netesp")
public class Practice implements java.io.Serializable {

	// Fields

	private Long practiceId;
	private Exam exam;
	private String content;
	private String name;
	private Set<Userpractice> userpractices = new HashSet<Userpractice>(0);

	// Constructors

	/** default constructor */
	public Practice() {
	}

	/** minimal constructor */
	public Practice(Long practiceId, Exam exam, String content, String name) {
		this.practiceId = practiceId;
		this.exam = exam;
		this.content = content;
		this.name = name;
	}

	/** full constructor */
	public Practice(Long practiceId, Exam exam, String content, String name,
			Set<Userpractice> userpractices) {
		this.practiceId = practiceId;
		this.exam = exam;
		this.content = content;
		this.name = name;
		this.userpractices = userpractices;
	}

	// Property accessors
	@Id
	@Column(name = "practice_id", unique = true, nullable = false)
	public Long getPracticeId() {
		return this.practiceId;
	}

	public void setPracticeId(Long practiceId) {
		this.practiceId = practiceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exam_id", nullable = false)
	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Column(name = "content", nullable = false, length = 1000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "practice")
	public Set<Userpractice> getUserpractices() {
		return this.userpractices;
	}

	public void setUserpractices(Set<Userpractice> userpractices) {
		this.userpractices = userpractices;
	}

}