package train.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Notdone entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "notdone", catalog = "netesp")
public class Notdone implements java.io.Serializable {

	// Fields

	private Long notDoneId;
	private User user;
	private String content;
	private String type;
	private Timestamp createTime;

	// Constructors

	/** default constructor */
	public Notdone() {
	}

	/** minimal constructor */
	public Notdone(Long notDoneId, User user, Timestamp createTime) {
		this.notDoneId = notDoneId;
		this.user = user;
		this.createTime = createTime;
	}

	/** full constructor */
	public Notdone(Long notDoneId, User user, String content, String type,
			Timestamp createTime) {
		this.notDoneId = notDoneId;
		this.user = user;
		this.content = content;
		this.type = type;
		this.createTime = createTime;
	}

	// Property accessors
	@Id
	@Column(name = "not_done_id", unique = true, nullable = false)
	public Long getNotDoneId() {
		return this.notDoneId;
	}

	public void setNotDoneId(Long notDoneId) {
		this.notDoneId = notDoneId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "content", length = 1000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "type", length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "create_time", nullable = false, length = 19)
	public Timestamp getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}