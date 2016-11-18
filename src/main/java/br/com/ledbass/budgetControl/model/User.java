package br.com.ledbass.budgetControl.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Class representing an user
 * @author ledbass
 *
 */
@Entity
@Table(name="user")
public class User implements Serializable {
	
	private static final long serialVersionUID = 7124951352218747021L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private long userId;
	
	private String username;
	private String email;
	private String password;
	@Transient
	private String confirmPassword;
	
	/**
	 * Default class constructor
	 */
	public User() {}

	/**
	 * @return the id
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the id to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}	
}
