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
 * Coursewarecategory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "coursewarecategory", catalog = "netesp")
public class Coursewarecategory implements java.io.Serializable {

	// Fields

	private Long categoryId;
	private String name;
	private Long parentId;
	private Set<Courseware> coursewares = new HashSet<Courseware>(0);

	// Constructors

	/** default constructor */
	public Coursewarecategory() {
	}

	/** minimal constructor */
	public Coursewarecategory(Long categoryId, String name, Long parentId) {
		this.categoryId = categoryId;
		this.name = name;
		this.parentId = parentId;
	}

	/** full constructor */
	public Coursewarecategory(Long categoryId, String name, Long parentId,
			Set<Courseware> coursewares) {
		this.categoryId = categoryId;
		this.name = name;
		this.parentId = parentId;
		this.coursewares = coursewares;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "coursewarecategory")
	public Set<Courseware> getCoursewares() {
		return this.coursewares;
	}

	public void setCoursewares(Set<Courseware> coursewares) {
		this.coursewares = coursewares;
	}

}