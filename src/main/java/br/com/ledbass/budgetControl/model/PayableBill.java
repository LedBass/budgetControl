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
 * This class represents the payable bill
 * @author ledbass
 *
 */
@Entity
@Table(name="payable-bill")
public class PayableBill implements Serializable {
	
	private static final long serialVersionUID = 3320365717156258736L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="payable_bill_id", nullable=false, unique=true)
	private Long payableBillId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="account_id", nullable=false)
	private Account account;
	private String payableBillType;
	@Column(precision=6)
	private Float payableBillValue;
	@Column(length=360)
	private String description;
	@Temporal(TemporalType.DATE)
	private Date billMaturityDate;
	
	/**
	 * Default class constructor
	 */
	public PayableBill() {}

	/**
	 * @return the id
	 */
	public Long getPayableBillId() {
		return payableBillId;
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
	 * @param id the id to set
	 */
	public void setPayableBillId(Long payableBillId) {
		this.payableBillId = payableBillId;
	}

	/**
	 * @return the payableType
	 */
	public String getPayableType() {
		return payableBillType;
	}

	/**
	 * @param payableType the payableType to set
	 */
	public void setPayableType(String payableType) {
		this.payableBillType = payableType;
	}

	/**
	 * @return the payableValue
	 */
	public Float getPayableValue() {
		return payableBillValue;
	}

	/**
	 * @param payableValue the payableValue to set
	 */
	public void setPayableValue(Float payableValue) {
		this.payableBillValue = payableValue;
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
	 * @return the billMaturityDate
	 */
	public Date getBillMaturityDate() {
		return billMaturityDate;
	}

	/**
	 * @param billMaturityDate the billMaturityDate to set
	 */
	public void setBillMaturityDate(Date billMaturityDate) {
		this.billMaturityDate = billMaturityDate;
	}	
}
