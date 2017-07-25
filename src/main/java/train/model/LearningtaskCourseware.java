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
 * LearningtaskCourseware entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "learningtask_courseware", catalog = "netesp")
public class LearningtaskCourseware implements java.io.Serializable {

	// Fields

	private LearningtaskCoursewareId id;
	private Courseware courseware;
	private Learningtask learningtask;

	// Constructors

	/** default constructor */
	public LearningtaskCourseware() {
	}

	/** full constructor */
	public LearningtaskCourseware(LearningtaskCoursewareId id,
			Courseware courseware, Learningtask learningtask) {
		this.id = id;
		this.courseware = courseware;
		this.learningtask = learningtask;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "learningTaskId", column = @Column(name = "learning_task_id", nullable = false)),
			@AttributeOverride(name = "coursewareId", column = @Column(name = "courseware_id", nullable = false)) })
	public LearningtaskCoursewareId getId() {
		return this.id;
	}

	public void setId(LearningtaskCoursewareId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "courseware_id", nullable = false, insertable = false, updatable = false)
	public Courseware getCourseware() {
		return this.courseware;
	}

	public void setCourseware(Courseware courseware) {
		this.courseware = courseware;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "learning_task_id", nullable = false, insertable = false, updatable = false)
	public Learningtask getLearningtask() {
		return this.learningtask;
	}

	public void setLearningtask(Learningtask learningtask) {
		this.learningtask = learningtask;
	}

}