package com.mortgeasy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.mortgeasy.common.BaseEntity;


/**
 * PaymentFrequency
 */
@Entity
@Table(name=PaymentFrequency.TABLE_NAME)
@SequenceGenerator(allocationSize=1, name="gen_payment_frequency", sequenceName="payment_frequency_id_seq")
public class PaymentFrequency extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "payment_frequency";

	private Integer id;
	private String description;
	private Frequency frequency;
	private Double frequencyValue;
	
	public PaymentFrequency() {
	}
	
	@Id
	@GeneratedValue(generator="gen_payment_frequency", strategy=GenerationType.SEQUENCE)
	@Column(name="payment_frequency_id", unique=true, nullable=false)
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

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="frequency_id")
	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	@Column(name = "frequency_value")
	public Double getFrequencyValue() {
		return frequencyValue;
	}

	public void setFrequencyValue(Double frequencyValue) {
		this.frequencyValue = frequencyValue;
	}
	
}
