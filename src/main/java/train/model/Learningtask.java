package train.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Learningtask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "learningtask", catalog = "netesp")
public class Learningtask implements java.io.Serializable {

	// Fields

	private Long learningTaskId;
	private String name;
	private String content;
	private Date startDate;
	private Date endDate;
	private Set<LearningtaskCourseware> learningtaskCoursewares = new HashSet<LearningtaskCourseware>(
			0);
	private Set<Userlearningtask> userlearningtasks = new HashSet<Userlearningtask>(
			0);

	// Constructors

	/** default constructor */
	public Learningtask() {
	}

	/** minimal constructor */
	public Learningtask(Long learningTaskId, String name, String content,
			Date startDate, Date endDate) {
		this.learningTaskId = learningTaskId;
		this.name = name;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	/** full constructor */
	public Learningtask(Long learningTaskId, String name, String content,
			Date startDate, Date endDate,
			Set<LearningtaskCourseware> learningtaskCoursewares,
			Set<Userlearningtask> userlearningtasks) {
		this.learningTaskId = learningTaskId;
		this.name = name;
		this.content = content;
		this.startDate = startDate;
		this.endDate = endDate;
		this.learningtaskCoursewares = learningtaskCoursewares;
		this.userlearningtasks = userlearningtasks;
	}

	// Property accessors
	@Id
	@Column(name = "learning_task_id", unique = true, nullable = false)
	public Long getLearningTaskId() {
		return this.learningTaskId;
	}

	public void setLearningTaskId(Long learningTaskId) {
		this.learningTaskId = learningTaskId;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "content", nullable = false, length = 1000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "start_date", nullable = false, length = 10)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "end_date", nullable = false, length = 10)
	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "learningtask")
	public Set<LearningtaskCourseware> getLearningtaskCoursewares() {
		return this.learningtaskCoursewares;
	}

	public void setLearningtaskCoursewares(
			Set<LearningtaskCourseware> learningtaskCoursewares) {
		this.learningtaskCoursewares = learningtaskCoursewares;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "learningtask")
	public Set<Userlearningtask> getUserlearningtasks() {
		return this.userlearningtasks;
	}

	public void setUserlearningtasks(Set<Userlearningtask> userlearningtasks) {
		this.userlearningtasks = userlearningtasks;
	}

}