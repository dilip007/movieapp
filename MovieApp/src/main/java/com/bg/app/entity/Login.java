package com.bg.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="login")
@Audited
public class Login implements Serializable{

	private static final long serialVersionUID = -8307459026735582238L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer login_id;
	
	@NotNull
	@Column(name="username")
	private String userName;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	@Transient
	private String passwordRepeat;
	
	@JsonIgnore
    @Column(name="last_update")
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;

	public Integer getLogin_id() {
		return login_id;
	}

	public void setLogin_id(Integer login_id) {
		this.login_id = login_id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getPasswordRepeat() {
		return passwordRepeat;
	}

	public void setPasswordRepeat(String passwordRepeat) {
		this.passwordRepeat = passwordRepeat;
	}
	
	@PrePersist
	@PreUpdate
	public void saveOrUpdate() {
		this.setLastUpdate(new Date());
	}

	@Override
	public String toString() {
		return "Login [login_id=" + login_id + ", userName=" + userName + ", email=" + email + ", password=" + password
				+ ", passwordRepeat=" + passwordRepeat + ", lastUpdate=" + lastUpdate + "]";
	}

}
