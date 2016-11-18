package br.com.ledbass.budgetControl.model.types;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author ledbass
 *
 */
@Entity
@Table(name="bank_account_type")
public class BankAccountType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6152882633156431717L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bankAccountTypeId;
	
	private String type;
	
	/**
	 * Default class constructor
	 */
	public BankAccountType() {}

	/**
	 * @return the id
	 */
	public int getBankAccountTypeId() {
		return bankAccountTypeId;
	}

	/**
	 * @param id the id to set
	 */
	public void setBankAccountTypeId(int bankAccountTypeId) {
		this.bankAccountTypeId = bankAccountTypeId;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
