package org.managementsystem.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	private Integer sectionNo;

	private Integer userNo;
	private String userMail;
	private String password;

	public User() {

	}

	public User(Integer sectionNo, Integer userNo, String userMail,
			String password) {
		this.sectionNo = sectionNo;
		this.userNo = userNo;
		this.userMail = userMail;
		this.password = password;
	}

	@Column(name = "section_no")
	public Integer getSectionNo() {
		return sectionNo;
	}

	public void setSectionNo(Integer sectionNo) {
		this.sectionNo = sectionNo;
	}

	@Id
	@Column(name = "user_no", nullable = false)
	public Integer getUserNo() {
		return userNo;
	}

	public void setUserNo(Integer userNo) {
		this.userNo = userNo;
	}

	@Column(name = "user_name", nullable = false)
	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
