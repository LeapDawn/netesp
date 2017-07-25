package train.model;

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
 * Courseware entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "courseware", catalog = "netesp")
public class Courseware implements java.io.Serializable {

	// Fields

	private Long coursewareId;
	private Coursewarecategory coursewarecategory;
	private String name;
	private String speakerName;
	private String speakerInformation;
	private Integer coursewareDuration;
	private String commendLevel;
	private String description;
	private String type;
	private String content;
	private Set<LearningtaskCourseware> learningtaskCoursewares = new HashSet<LearningtaskCourseware>(
			0);

	// Constructors

	/** default constructor */
	public Courseware() {
	}

	/** minimal constructor */
	public Courseware(Long coursewareId, Coursewarecategory coursewarecategory,
			String name, String speakerName, String speakerInformation,
			Integer coursewareDuration, String type, String content) {
		this.coursewareId = coursewareId;
		this.coursewarecategory = coursewarecategory;
		this.name = name;
		this.speakerName = speakerName;
		this.speakerInformation = speakerInformation;
		this.coursewareDuration = coursewareDuration;
		this.type = type;
		this.content = content;
	}

	/** full constructor */
	public Courseware(Long coursewareId, Coursewarecategory coursewarecategory,
			String name, String speakerName, String speakerInformation,
			Integer coursewareDuration, String commendLevel,
			String description, String type, String content,
			Set<LearningtaskCourseware> learningtaskCoursewares) {
		this.coursewareId = coursewareId;
		this.coursewarecategory = coursewarecategory;
		this.name = name;
		this.speakerName = speakerName;
		this.speakerInformation = speakerInformation;
		this.coursewareDuration = coursewareDuration;
		this.commendLevel = commendLevel;
		this.description = description;
		this.type = type;
		this.content = content;
		this.learningtaskCoursewares = learningtaskCoursewares;
	}

	// Property accessors
	@Id
	@Column(name = "courseware_id", unique = true, nullable = false)
	public Long getCoursewareId() {
		return this.coursewareId;
	}

	public void setCoursewareId(Long coursewareId) {
		this.coursewareId = coursewareId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", nullable = false)
	public Coursewarecategory getCoursewarecategory() {
		return this.coursewarecategory;
	}

	public void setCoursewarecategory(Coursewarecategory coursewarecategory) {
		this.coursewarecategory = coursewarecategory;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "speaker_name", nullable = false, length = 50)
	public String getSpeakerName() {
		return this.speakerName;
	}

	public void setSpeakerName(String speakerName) {
		this.speakerName = speakerName;
	}

	@Column(name = "speaker_information", nullable = false, length = 100)
	public String getSpeakerInformation() {
		return this.speakerInformation;
	}

	public void setSpeakerInformation(String speakerInformation) {
		this.speakerInformation = speakerInformation;
	}

	@Column(name = "courseware_duration", nullable = false)
	public Integer getCoursewareDuration() {
		return this.coursewareDuration;
	}

	public void setCoursewareDuration(Integer coursewareDuration) {
		this.coursewareDuration = coursewareDuration;
	}

	@Column(name = "commend_level", length = 10)
	public String getCommendLevel() {
		return this.commendLevel;
	}

	public void setCommendLevel(String commendLevel) {
		this.commendLevel = commendLevel;
	}

	@Column(name = "description", length = 100)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "type", nullable = false, length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "content", nullable = false, length = 5000)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "courseware")
	public Set<LearningtaskCourseware> getLearningtaskCoursewares() {
		return this.learningtaskCoursewares;
	}

	public void setLearningtaskCoursewares(
			Set<LearningtaskCourseware> learningtaskCoursewares) {
		this.learningtaskCoursewares = learningtaskCoursewares;
	}

}