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
 * Userpractice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "userpractice", catalog = "netesp")
public class Userpractice implements java.io.Serializable {

	// Fields

	private UserpracticeId id;
	private User user;
	private Practice practice;
	private String isComplete;
	private String userAnswer;

	// Constructors

	/** default constructor */
	public Userpractice() {
	}

	/** minimal constructor */
	public Userpractice(UserpracticeId id, User user, Practice practice,
			String isComplete) {
		this.id = id;
		this.user = user;
		this.practice = practice;
		this.isComplete = isComplete;
	}

	/** full constructor */
	public Userpractice(UserpracticeId id, User user, Practice practice,
			String isComplete, String userAnswer) {
		this.id = id;
		this.user = user;
		this.practice = practice;
		this.isComplete = isComplete;
		this.userAnswer = userAnswer;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "practiceId", column = @Column(name = "practice_id", nullable = false)),
			@AttributeOverride(name = "userId", column = @Column(name = "user_id", nullable = false, length = 20)) })
	public UserpracticeId getId() {
		return this.id;
	}

	public void setId(UserpracticeId id) {
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
	@JoinColumn(name = "practice_id", nullable = false, insertable = false, updatable = false)
	public Practice getPractice() {
		return this.practice;
	}

	public void setPractice(Practice practice) {
		this.practice = practice;
	}

	@Column(name = "is_complete", nullable = false, length = 20)
	public String getIsComplete() {
		return this.isComplete;
	}

	public void setIsComplete(String isComplete) {
		this.isComplete = isComplete;
	}

	@Column(name = "user_answer", length = 5000)
	public String getUserAnswer() {
		return this.userAnswer;
	}

	public void setUserAnswer(String userAnswer) {
		this.userAnswer = userAnswer;
	}

}