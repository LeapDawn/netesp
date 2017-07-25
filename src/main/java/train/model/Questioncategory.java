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
 * Questioncategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "questioncategory", catalog = "netesp")
public class Questioncategory implements java.io.Serializable {

	// Fields

	private Long categoryId;
	private String name;
	private Long parentId;
	private Set<Question> questions = new HashSet<Question>(0);

	// Constructors

	/** default constructor */
	public Questioncategory() {
	}

	/** minimal constructor */
	public Questioncategory(Long categoryId, String name, Long parentId) {
		this.categoryId = categoryId;
		this.name = name;
		this.parentId = parentId;
	}

	/** full constructor */
	public Questioncategory(Long categoryId, String name, Long parentId,
			Set<Question> questions) {
		this.categoryId = categoryId;
		this.name = name;
		this.parentId = parentId;
		this.questions = questions;
	}

	// Property accessors
	@Id
	@Column(name = "category_id", unique = true, nullable = false)
	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "parent_id", nullable = false)
	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "questioncategory")
	public Set<Question> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

}