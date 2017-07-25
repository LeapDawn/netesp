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
 * Questiondifficulty entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "questiondifficulty", catalog = "netesp")
public class Questiondifficulty implements java.io.Serializable {

	// Fields

	private Long difficultyId;
	private String name;
	private Set<Question> questions = new HashSet<Question>(0);

	// Constructors

	/** default constructor */
	public Questiondifficulty() {
	}

	/** minimal constructor */
	public Questiondifficulty(Long difficultyId, String name) {
		this.difficultyId = difficultyId;
		this.name = name;
	}

	/** full constructor */
	public Questiondifficulty(Long difficultyId, String name,
			Set<Question> questions) {
		this.difficultyId = difficultyId;
		this.name = name;
		this.questions = questions;
	}

	// Property accessors
	@Id
	@Column(name = "difficulty_id", unique = true, nullable = false)
	public Long getDifficultyId() {
		return this.difficultyId;
	}

	public void setDifficultyId(Long difficultyId) {
		this.difficultyId = difficultyId;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "questiondifficulty")
	public Set<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}