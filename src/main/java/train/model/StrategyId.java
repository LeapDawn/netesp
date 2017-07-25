package train.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * StrategyId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class StrategyId implements java.io.Serializable {

	// Fields

	private Long strategyId;
	private Long categoryId;
	private String type;

	// Constructors

	/** default constructor */
	public StrategyId() {
	}

	/** full constructor */
	public StrategyId(Long strategyId, Long categoryId, String type) {
		this.strategyId = strategyId;
		this.categoryId = categoryId;
		this.type = type;
	}

	// Property accessors

	@Column(name = "strategy_id", nullable = false)
	public Long getStrategyId() {
		return this.strategyId;
	}

	public void setStrategyId(Long strategyId) {
		this.strategyId = strategyId;
	}

	@Column(name = "category_id", nullable = false)
	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "type", nullable = false, length = 50)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof StrategyId))
			return false;
		StrategyId castOther = (StrategyId) other;

		return ((this.getStrategyId() == castOther.getStrategyId()) || (this
				.getStrategyId() != null && castOther.getStrategyId() != null && this
				.getStrategyId().equals(castOther.getStrategyId())))
				&& ((this.getCategoryId() == castOther.getCategoryId()) || (this
						.getCategoryId() != null
						&& castOther.getCategoryId() != null && this
						.getCategoryId().equals(castOther.getCategoryId())))
				&& ((this.getType() == castOther.getType()) || (this.getType() != null
						&& castOther.getType() != null && this.getType()
						.equals(castOther.getType())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getStrategyId() == null ? 0 : this.getStrategyId()
						.hashCode());
		result = 37
				* result
				+ (getCategoryId() == null ? 0 : this.getCategoryId()
						.hashCode());
		result = 37 * result
				+ (getType() == null ? 0 : this.getType().hashCode());
		return result;
	}

}