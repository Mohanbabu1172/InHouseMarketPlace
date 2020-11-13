package com.cg.InHouseMarketPlace.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Proposal {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int propId;
	private String proposal;
	private double amount;
	private LocalDate proposalDate;
	private boolean isAccepted;
	private LocalDate acceptedOn;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "proposal_res_id")
	private Resource resource;

	@ManyToOne
	@JoinColumn(name = "proposal_emp_id")
	private Employee employee;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getPropId() {
		return propId;
	}

	public void setPropId(int propId) {
		this.propId = propId;
	}

	public String getProposal() {
		return proposal;
	}

	public void setProposal(String proposal) {
		this.proposal = proposal;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getProposalDate() {
		return proposalDate;
	}

	public void setProposalDate(LocalDate proposalDate) {
		this.proposalDate = proposalDate;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public LocalDate getAcceptedOn() {
		return acceptedOn;
	}

	public void setAcceptedOn(LocalDate acceptedOn) {
		this.acceptedOn = acceptedOn;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}
	

	public Proposal(int propId, String proposal, double amount, LocalDate proposalDate, boolean isAccepted,
			LocalDate acceptedOn, Employee employee, Resource resource) {
		super();
		this.propId = propId;
		this.proposal = proposal;
		this.amount = amount;
		this.proposalDate = proposalDate;
		this.isAccepted = isAccepted;
		this.acceptedOn = acceptedOn;
		this.resource = resource;
		this.employee = employee;
	}

	public Proposal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Proposal(int propId2, String proposal2, float amount2, Date date, boolean isAccepted2, LocalDate now,
			Employee emp, Resource res) {
		// TODO Auto-generated constructor stub
	}

	public Proposal(int propId2, String proposal2, double amount2, LocalDate now, boolean isAccepted2, LocalDate now2,
			Resource res, Employee emp) {
		// TODO Auto-generated constructor stub
	}

	public Proposal(int propId2, String proposal2, float amount2, Date date, boolean isAccepted2, Date date2,
			Employee emp, Resource res) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Proposal [propId=" + propId + ", proposal=" + proposal + ", amount=" + amount + ", proposalDate="
				+ proposalDate + ", isAccepted=" + isAccepted + ", acceptedOn=" + acceptedOn + ", emp=" + "]";
	}

}
