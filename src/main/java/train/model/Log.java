package train.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Log entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "log", catalog = "netesp")
public class Log implements java.io.Serializable {

	// Fields

	private Long logId;
	private Integer accessQuantity;
	private String accessIp;
	private Long accessStayTime;

	// Constructors

	/** default constructor */
	public Log() {
	}

	/** full constructor */
	public Log(Long logId, Integer accessQuantity, String accessIp,
			Long accessStayTime) {
		this.logId = logId;
		this.accessQuantity = accessQuantity;
		this.accessIp = accessIp;
		this.accessStayTime = accessStayTime;
	}

	// Property accessors
	@Id
	@Column(name = "log_id", unique = true, nullable = false)
	public Long getLogId() {
		return this.logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	@Column(name = "access_quantity", nullable = false)
	public Integer getAccessQuantity() {
		return this.accessQuantity;
	}

	public void setAccessQuantity(Integer accessQuantity) {
		this.accessQuantity = accessQuantity;
	}

	@Column(name = "access_ip", nullable = false, length = 4)
	public String getAccessIp() {
		return this.accessIp;
	}

	public void setAccessIp(String accessIp) {
		this.accessIp = accessIp;
	}

	@Column(name = "access_stay_time", nullable = false)
	public Long getAccessStayTime() {
		return this.accessStayTime;
	}

	public void setAccessStayTime(Long accessStayTime) {
		this.accessStayTime = accessStayTime;
	}

}