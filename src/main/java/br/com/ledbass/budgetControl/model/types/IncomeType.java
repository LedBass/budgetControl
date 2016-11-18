package br.com.ledbass.budgetControl.model.types;

import java.io.Serializable;

import javax.persistence.Column;
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
@Table(name="income_type")
public class IncomeType implements Serializable {
	
	private static final long serialVersionUID = 5930631333835827878L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="income_type_id", nullable=false, unique=true)
	private int incomeTypeId;
	@Column(nullable=false, unique=true)
	private String type;
	
	/**
	 * Default class constructor
	 */
	public IncomeType() {}

	/**
	 * @return the id
	 */
	public int getId() {
		return incomeTypeId;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.incomeTypeId = id;
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
