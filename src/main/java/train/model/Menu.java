package train.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "menu", catalog = "netesp")
public class Menu implements java.io.Serializable {

	// Fields

	private Long menuId;
	private String name;
	private String urlAddress;
	private Long parentId;

	// Constructors

	/** default constructor */
	public Menu() {
	}

	/** full constructor */
	public Menu(Long menuId, String name, String urlAddress, Long parentId) {
		this.menuId = menuId;
		this.name = name;
		this.urlAddress = urlAddress;
		this.parentId = parentId;
	}

	// Property accessors
	@Id
	@Column(name = "menu_id", unique = true, nullable = false)
	public Long getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "url_address", nullable = false)
	public String getUrlAddress() {
		return this.urlAddress;
	}

	public void setUrlAddress(String urlAddress) {
		this.urlAddress = urlAddress;
	}

	@Column(name = "parent_id", nullable = false)
	public Long getParentId() {
		return this.parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}