package br.com.ledbass.budgetControl.model.types;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payable_bill_type")
public class PayableBillType implements Serializable {
	
	private static final long serialVersionUID = -969273091565797388L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, unique=true)
	private int id;
	@Column(nullable=false, unique=true)
	private String type;
	
	/**
	 * Default class constructor
	 */
	public PayableBillType() {}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
