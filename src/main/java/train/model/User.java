package train.model;

import java.lang.*;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "netesp")
public class User implements java.io.Serializable {

	// Fields

	private String userId;
	private Department department;
	private String password;
	private String name;
	private Long permissionId;
	private Set<Notice> notices = new HashSet<Notice>(0);
	private Set<Postcomment> postcomments = new HashSet<Postcomment>(0);
	private Set<Userlearningtask> userlearningtasks = new HashSet<Userlearningtask>(
			0);
	private Set<Thread> threads = new HashSet<Thread>(0);
	private Set<Repositorycategory> repositorycategories = new HashSet<Repositorycategory>(
			0);
	private Set<Post> posts = new HashSet<Post>(0);
	private Set<Knowledge> knowledges = new HashSet<Knowledge>(0);
	private Set<Notdone> notdones = new HashSet<Notdone>(0);
	private Set<Board> boards = new HashSet<Board>(0);
	private Set<Userpractice> userpractices = new HashSet<Userpractice>(0);
	private Set<Knowledgecomment> knowledgecomments = new HashSet<Knowledgecomment>(
			0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String userId, Department department, String password,
			String name, Long permissionId) {
		this.userId = userId;
		this.department = department;
		this.password = password;
		this.name = name;
		this.permissionId = permissionId;
	}

	/** full constructor */
	public User(String userId, Department department, String password,
			String name, Long permissionId, Set<Notice> notices,
			Set<Postcomment> postcomments,
			Set<Userlearningtask> userlearningtasks, Set<Thread> threads,
			Set<Repositorycategory> repositorycategories, Set<Post> posts,
			Set<Knowledge> knowledges, Set<Notdone> notdones,
			Set<Board> boards, Set<Userpractice> userpractices,
			Set<Knowledgecomment> knowledgecomments) {
		this.userId = userId;
		this.department = department;
		this.password = password;
		this.name = name;
		this.permissionId = permissionId;
		this.notices = notices;
		this.postcomments = postcomments;
		this.userlearningtasks = userlearningtasks;
		this.threads = threads;
		this.repositorycategories = repositorycategories;
		this.posts = posts;
		this.knowledges = knowledges;
		this.notdones = notdones;
		this.boards = boards;
		this.userpractices = userpractices;
		this.knowledgecomments = knowledgecomments;
	}

	// Property accessors
	@Id
	@Column(name = "user_id", unique = true, nullable = false, length = 20)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id", nullable = false)
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "permission_id", nullable = false)
	public Long getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Notice> getNotices() {
		return this.notices;
	}

	public void setNotices(Set<Notice> notices) {
		this.notices = notices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Postcomment> getPostcomments() {
		return this.postcomments;
	}

	public void setPostcomments(Set<Postcomment> postcomments) {
		this.postcomments = postcomments;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Userlearningtask> getUserlearningtasks() {
		return this.userlearningtasks;
	}

	public void setUserlearningtasks(Set<Userlearningtask> userlearningtasks) {
		this.userlearningtasks = userlearningtasks;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Thread> getThreads() {
		return this.threads;
	}

	public void setThreads(Set<Thread> threads) {
		this.threads = threads;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Repositorycategory> getRepositorycategories() {
		return this.repositorycategories;
	}

	public void setRepositorycategories(
			Set<Repositorycategory> repositorycategories) {
		this.repositorycategories = repositorycategories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Post> getPosts() {
		return this.posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Knowledge> getKnowledges() {
		return this.knowledges;
	}

	public void setKnowledges(Set<Knowledge> knowledges) {
		this.knowledges = knowledges;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Notdone> getNotdones() {
		return this.notdones;
	}

	public void setNotdones(Set<Notdone> notdones) {
		this.notdones = notdones;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Board> getBoards() {
		return this.boards;
	}

	public void setBoards(Set<Board> boards) {
		this.boards = boards;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Userpractice> getUserpractices() {
		return this.userpractices;
	}

	public void setUserpractices(Set<Userpractice> userpractices) {
		this.userpractices = userpractices;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
	public Set<Knowledgecomment> getKnowledgecomments() {
		return this.knowledgecomments;
	}

	public void setKnowledgecomments(Set<Knowledgecomment> knowledgecomments) {
		this.knowledgecomments = knowledgecomments;
	}

}