package com.mortgeasy.entity;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.mortgeasy.common.BaseEntity;


/**
 * MortgageProposal
 */
@Entity
@Table(name=MortgageProposal.TABLE_NAME)
@SequenceGenerator(allocationSize=1, name="gen_mortgage_proposal", sequenceName="mortgage_proposal_id_seq")
public class MortgageProposal extends BaseEntity<Integer> {

	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "mortgage_proposal";

	private Integer id;
	private String goal;
	private Double purchasePrice;
	private Double downPayment;
	private Double interestRate;
	private Double totalMortgage;
	private Integer amortizationPeriod;
	private PaymentFrequency paymentFrequency;
	private String userId;
	private Date createdDate;
	
	
	public MortgageProposal() {
	}
	
	@Id
	@GeneratedValue(generator="gen_mortgage_proposal", strategy=GenerationType.SEQUENCE)
	@Column(name="mortgage_proposal_id", unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
		
	@Column(name="goal")
	public String getGoal() {
		return this.goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="payment_frequency_id")
	public PaymentFrequency getPaymentFrequency() {
		return paymentFrequency;
	}

	public void setPaymentFrequency(PaymentFrequency paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	@Column(name="purchase_price")
	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	@Column(name="down_payment")
	public Double getDownPayment() {
		return downPayment;
	}

	public void setDownPayment(Double downPayment) {
		this.downPayment = downPayment;
	}

	@Column(name="interest_rate")
	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	@Column(name="total_mortgage")
	public Double getTotalMortgage() {
		return totalMortgage;
	}

	public void setTotalMortgage(Double totalMortgage) {
		this.totalMortgage = totalMortgage;
	}

	@Column(name="amortization_period")
	public Integer getAmortizationPeriod() {
		return amortizationPeriod;
	}

	public void setAmortizationPeriod(Integer amortizationPeriod) {
		this.amortizationPeriod = amortizationPeriod;
	}

	@Column(name="user_id")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
