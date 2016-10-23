package com.mortgeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mortgeasy.common.BaseEntity;


/**
 * Frequency
 */
@Entity
@Table(name=Frequency.TABLE_NAME)
@SequenceGenerator(allocationSize=1, name="gen_frequency", sequenceName="frequency_id_seq")
public class Frequency extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "frequency";

	private Integer id;
	private String description;
	
	public Frequency() {
	
	}
	
	@Id
	@GeneratedValue(generator="gen_frequency", strategy=GenerationType.SEQUENCE)
	@Column(name="frequency_id", unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	@Column(name="description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
