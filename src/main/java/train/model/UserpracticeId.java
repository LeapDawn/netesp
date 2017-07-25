package train.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserpracticeId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class UserpracticeId implements java.io.Serializable {

	// Fields

	private Long practiceId;
	private String userId;

	// Constructors

	/** default constructor */
	public UserpracticeId() {
	}

	/** full constructor */
	public UserpracticeId(Long practiceId, String userId) {
		this.practiceId = practiceId;
		this.userId = userId;
	}

	// Property accessors

	@Column(name = "practice_id", nullable = false)
	public Long getPracticeId() {
		return this.practiceId;
	}

	public void setPracticeId(Long practiceId) {
		this.practiceId = practiceId;
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
		if (!(other instanceof UserpracticeId))
			return false;
		UserpracticeId castOther = (UserpracticeId) other;

		return ((this.getPracticeId() == castOther.getPracticeId()) || (this
				.getPracticeId() != null && castOther.getPracticeId() != null && this
				.getPracticeId().equals(castOther.getPracticeId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getPracticeId() == null ? 0 : this.getPracticeId()
						.hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}