package br.com.ledbass.budgetControl.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author ledbass
 *
 */
@Entity
@Table(name="account")
public class Account implements Serializable {
	
	private static final long serialVersionUID = -814994670663674904L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_id", unique=true, nullable=false)
	private Long accountId;
	
	private String bankName;
	private String bankAccountType;
	@Transient
	private Float incomeTotalValue;
	@Transient
	private Float billTotalValue;
	@Transient
	private Date startDate;
	@Transient
	private Date endDate;
	
	/**
	 * Default class constructor
	 */
	public Account() {}
	
	/**
	 * Class constructor 
	 * 
	 * @param Use a {@code String} - bankAccountType the type of the account 
	 * @param startDate Use a {@link Date} - the date to start the lists of {@link PayableBill}s and {@link Income}s if 
	 * it's null, then it will be set at the first of the current month
	 * @param endDate Use a {@link Date} - the same as the {@code startDate}
	 */
	public Account(String bankAccountType, Date startDate,	Date endDate) {
		
		this.bankAccountType = bankAccountType;
		
		/*
		 * If the startDate is null, then set the current month in the first day
		 */
		if (startDate == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			startDate = calendar.getTime();
			this.startDate = startDate;
		
		} else {
			this.startDate = startDate;
		}
		
		/*
		 * If the end is null, then set the current date
		 */
		if (endDate == null) {
			endDate = getCurrentDate();
			this.endDate = endDate;
			
		} else {
			this.endDate = endDate;
		}
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return accountId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.accountId = id;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the bankAccountType
	 */
	public String getBankAccountType() {
		return bankAccountType;
	}

	/**
	 * @param bankAccountType the bankAccountType to set
	 */
	public void setBankAccountType(String bankAccountType) {
		this.bankAccountType = bankAccountType;
	}

	/**
	 * @return the incomeTotalValue
	 */
	public Float getIncomeTotalValue() {
		return incomeTotalValue;
	}

	/**
	 * @param incomeTotalValue the incomeTotalValue to set
	 */
	public void setIncomeTotalValue(Float incomeTotalValue) {
		this.incomeTotalValue = incomeTotalValue;
	}

	/**
	 * @return the billTotalValue
	 */
	public Float getBillTotalValue() {
		return billTotalValue;
	}

	/**
	 * @param billTotalValue the billTotalValue to set
	 */
	public void setBillTotalValue(Float billTotalValue) {
		this.billTotalValue = billTotalValue;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	private Date getCurrentDate() {
		Calendar calendar = Calendar.getInstance();
		Date currentDate = calendar.getTime();
		return currentDate;
	}
}
