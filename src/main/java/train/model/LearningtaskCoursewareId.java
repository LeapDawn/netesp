package train.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * LearningtaskCoursewareId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class LearningtaskCoursewareId implements java.io.Serializable {

	// Fields

	private Long learningTaskId;
	private Long coursewareId;

	// Constructors

	/** default constructor */
	public LearningtaskCoursewareId() {
	}

	/** full constructor */
	public LearningtaskCoursewareId(Long learningTaskId, Long coursewareId) {
		this.learningTaskId = learningTaskId;
		this.coursewareId = coursewareId;
	}

	// Property accessors

	@Column(name = "learning_task_id", nullable = false)
	public Long getLearningTaskId() {
		return this.learningTaskId;
	}

	public void setLearningTaskId(Long learningTaskId) {
		this.learningTaskId = learningTaskId;
	}

	@Column(name = "courseware_id", nullable = false)
	public Long getCoursewareId() {
		return this.coursewareId;
	}

	public void setCoursewareId(Long coursewareId) {
		this.coursewareId = coursewareId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LearningtaskCoursewareId))
			return false;
		LearningtaskCoursewareId castOther = (LearningtaskCoursewareId) other;

		return ((this.getLearningTaskId() == castOther.getLearningTaskId()) || (this
				.getLearningTaskId() != null
				&& castOther.getLearningTaskId() != null && this
				.getLearningTaskId().equals(castOther.getLearningTaskId())))
				&& ((this.getCoursewareId() == castOther.getCoursewareId()) || (this
						.getCoursewareId() != null
						&& castOther.getCoursewareId() != null && this
						.getCoursewareId().equals(castOther.getCoursewareId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getLearningTaskId() == null ? 0 : this.getLearningTaskId()
						.hashCode());
		result = 37
				* result
				+ (getCoursewareId() == null ? 0 : this.getCoursewareId()
						.hashCode());
		return result;
	}

}