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
 * Userlearningtask entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userlearningtask", catalog = "netesp")
public class Userlearningtask implements java.io.Serializable {

	// Fields

	private UserlearningtaskId id;
	private User user;
	private Learningtask learningtask;
	private String isComplete;

	// Constructors

	/** default constructor */
	public Userlearningtask() {
	}

	/** full constructor */
	public Userlearningtask(UserlearningtaskId id, User user,
			Learningtask learningtask, String isComplete) {
		this.id = id;
		this.user = user;
		this.learningtask = learningtask;
		this.isComplete = isComplete;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "learningTaskId", column = @Column(name = "learning_task_id", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false, length = 20)) })
	public UserlearningtaskId getId() {
		return this.id;
	}

	public void setId(UserlearningtaskId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false, insertable = false, updatable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "learning_task_id", nullable = false, insertable = false, updatable = false)
	public Learningtask getLearningtask() {
		return this.learningtask;
	}

	public void setLearningtask(Learningtask learningtask) {
		this.learningtask = learningtask;
	}

	@Column(name = "is_complete", nullable = false, length = 20)
	public String getIsComplete() {
		return this.isComplete;
	}

	public void setIsComplete(String isComplete) {
		this.isComplete = isComplete;
	}

}