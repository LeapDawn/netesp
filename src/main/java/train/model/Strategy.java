package train.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Strategy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "strategy", catalog = "netesp")
public class Strategy implements java.io.Serializable {

	// Fields

	private StrategyId id;
	private String name;
	private Integer fullScore;
	private Integer passScore;
	private String purpose;
	private Integer lowerlimitDifficultyId;
	private Integer toplimitDifficultyId;
	private Integer perquestioncatPerquestiontypeQuantity;
	private Integer perquestioncatPerquestiontypeScore;
	private Integer perquestioncatPerquestiontypeOrder;

	// Constructors

	/** default constructor */
	public Strategy() {
	}

	/** full constructor */
	public Strategy(StrategyId id, String name, Integer fullScore,
			Integer passScore, String purpose, Integer lowerlimitDifficultyId,
			Integer toplimitDifficultyId,
			Integer perquestioncatPerquestiontypeQuantity,
			Integer perquestioncatPerquestiontypeScore,
			Integer perquestioncatPerquestiontypeOrder) {
		this.id = id;
		this.name = name;
		this.fullScore = fullScore;
		this.passScore = passScore;
		this.purpose = purpose;
		this.lowerlimitDifficultyId = lowerlimitDifficultyId;
		this.toplimitDifficultyId = toplimitDifficultyId;
		this.perquestioncatPerquestiontypeQuantity = perquestioncatPerquestiontypeQuantity;
		this.perquestioncatPerquestiontypeScore = perquestioncatPerquestiontypeScore;
		this.perquestioncatPerquestiontypeOrder = perquestioncatPerquestiontypeOrder;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "strategyId", column = @Column(name = "strategy_id", nullable = false)),
			@AttributeOverride(name = "categoryId", column = @Column(name = "category_id", nullable = false)),
			@AttributeOverride(name = "type", column = @Column(name = "type", nullable = false, length = 50)) })
	public StrategyId getId() {
		return this.id;
	}

	public void setId(StrategyId id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "full_score", nullable = false)
	public Integer getFullScore() {
		return this.fullScore;
	}

	public void setFullScore(Integer fullScore) {
		this.fullScore = fullScore;
	}

	@Column(name = "pass_score", nullable = false)
	public Integer getPassScore() {
		return this.passScore;
	}

	public void setPassScore(Integer passScore) {
		this.passScore = passScore;
	}

	@Column(name = "purpose", nullable = false, length = 100)
	public String getPurpose() {
		return this.purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name = "lowerlimit_difficulty_id", nullable = false)
	public Integer getLowerlimitDifficultyId() {
		return this.lowerlimitDifficultyId;
	}

	public void setLowerlimitDifficultyId(Integer lowerlimitDifficultyId) {
		this.lowerlimitDifficultyId = lowerlimitDifficultyId;
	}

	@Column(name = "toplimit_difficulty_id", nullable = false)
	public Integer getToplimitDifficultyId() {
		return this.toplimitDifficultyId;
	}

	public void setToplimitDifficultyId(Integer toplimitDifficultyId) {
		this.toplimitDifficultyId = toplimitDifficultyId;
	}

	@Column(name = "perquestioncat_perquestiontype_quantity", nullable = false)
	public Integer getPerquestioncatPerquestiontypeQuantity() {
		return this.perquestioncatPerquestiontypeQuantity;
	}

	public void setPerquestioncatPerquestiontypeQuantity(
			Integer perquestioncatPerquestiontypeQuantity) {
		this.perquestioncatPerquestiontypeQuantity = perquestioncatPerquestiontypeQuantity;
	}

	@Column(name = "perquestioncat_perquestiontype_score", nullable = false)
	public Integer getPerquestioncatPerquestiontypeScore() {
		return this.perquestioncatPerquestiontypeScore;
	}

	public void setPerquestioncatPerquestiontypeScore(
			Integer perquestioncatPerquestiontypeScore) {
		this.perquestioncatPerquestiontypeScore = perquestioncatPerquestiontypeScore;
	}

	@Column(name = "perquestioncat_perquestiontype_order", nullable = false)
	public Integer getPerquestioncatPerquestiontypeOrder() {
		return this.perquestioncatPerquestiontypeOrder;
	}

	public void setPerquestioncatPerquestiontypeOrder(
			Integer perquestioncatPerquestiontypeOrder) {
		this.perquestioncatPerquestiontypeOrder = perquestioncatPerquestiontypeOrder;
	}

}