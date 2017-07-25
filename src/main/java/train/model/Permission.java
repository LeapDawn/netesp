package train.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Permission entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "permission", catalog = "netesp")
public class Permission implements java.io.Serializable {

	// Fields

	private Long permissionId;
	private String name;

	// Constructors

	/** default constructor */
	public Permission() {
	}

	/** full constructor */
	public Permission(Long permissionId, String name) {
		this.permissionId = permissionId;
		this.name = name;
	}

	// Property accessors
	@Id
	@Column(name = "permission_id", unique = true, nullable = false)
	public Long getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}