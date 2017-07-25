package train.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserlearningtaskId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class UserlearningtaskId implements java.io.Serializable {

	// Fields

	private Long learningTaskId;
	private String userId;

	// Constructors

	/** default constructor */
	public UserlearningtaskId() {
	}

	/** full constructor */
	public UserlearningtaskId(Long learningTaskId, String userId) {
		this.learningTaskId = learningTaskId;
		this.userId = userId;
	}

	// Property accessors

	@Column(name = "learning_task_id", nullable = false)
	public Long getLearningTaskId() {
		return this.learningTaskId;
	}

	public void setLearningTaskId(Long learningTaskId) {
		this.learningTaskId = learningTaskId;
	}

	@Column(name = "user_id", nullable = false, length = 20)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserlearningtaskId))
			return false;
		UserlearningtaskId castOther = (UserlearningtaskId) other;

		return ((this.getLearningTaskId() == castOther.getLearningTaskId()) || (this
				.getLearningTaskId() != null
				&& castOther.getLearningTaskId() != null && this
				.getLearningTaskId().equals(castOther.getLearningTaskId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getLearningTaskId() == null ? 0 : this.getLearningTaskId()
						.hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}