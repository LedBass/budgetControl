package br.com.ledbass.budgetControl.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This class is a representation of a income budget
 * @author ledbass
 *
 */
@Entity
@Table(name="income")
public class Income implements Serializable {
	
	private static final long serialVersionUID = 7492440512290455218L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="income_id", nullable=false, unique=true)
	private Long incomeId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="account_id", nullable=false)
	private Account account;
	private String incomeType;
	@Column(precision=6)
	private Float IncomeValue;
	@Column(length=350)
	private String description;
	@Temporal(TemporalType.DATE)
	private Date incomeDate;
	
	/**
	 * Default class constructor
	 */
	public Income() {}

	/**
	 * @return the id
	 */
	public Long getIncimeId() {
		return incomeId;
	}

	/**
	 * @param id the id to set
	 */
	public void setIncomeId(Long incomeId) {
		this.incomeId = incomeId;
	}

	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}

	/**
	 * @return the incomeType
	 */
	public String getIncomeType() {
		return incomeType;
	}

	/**
	 * @param incomeType the incomeType to set
	 */
	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	/**
	 * @return the incomeValue
	 */
	public Float getIncomeValue() {
		return IncomeValue;
	}

	/**
	 * @param incomeValue the incomeValue to set
	 */
	public void setIncomeValue(Float incomeValue) {
		IncomeValue = incomeValue;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the incomeDate
	 */
	public Date getIncomeDate() {
		return incomeDate;
	}

	/**
	 * @param incomeDate the incomeDate to set
	 */
	public void setIncomeDate(Date incomeDate) {
		this.incomeDate = incomeDate;
	}
	
	
	
}
