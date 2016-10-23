package com.mortgeasy.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mortgeasy.common.BaseEntity;


/**
 * UserInfo
 */
@Entity
@Table(name=UserInfo.TABLE_NAME)
@SequenceGenerator(allocationSize=1, name="gen_user_info", sequenceName="user_info_id_seq")
public class UserInfo extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "user_info";

	private Integer id;
	private String fullName;
	private Date birthday;
	private Double montlyIncome;
	private String identificationNumber;
	private String occupation;
	
	
	public UserInfo() {
	
	}
	
	@Id
	@GeneratedValue(generator="gen_user_info", strategy=GenerationType.SEQUENCE)
	@Column(name="user_info_id", unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	@Column(name="full_name")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name="birthday")
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name="montly_income")
	public Double getMontlyIncome() {
		return montlyIncome;
	}

	public void setMontlyIncome(Double montlyIncome) {
		this.montlyIncome = montlyIncome;
	}

	@Column(name="identification_number")
	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	@Column(name="occupation")
	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	

}
