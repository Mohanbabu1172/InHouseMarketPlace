package com.cg.InHouseMarketPlace.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;


@Entity
public class Requirement extends Resource {
	private int reqId;
	private boolean isFulfilled;
	private LocalDate fulfilledOn;
	@OneToMany
	private List<Proposal> proposals;
	
	public int getReqId() {
		return reqId;
	}
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public boolean isFulfilled() {
		return isFulfilled;
	}
	public void setFulfilled(boolean isFulfilled) {
		this.isFulfilled = isFulfilled;
	}
	public LocalDate getFulfilledOn() {
		return fulfilledOn;
	}
	public void setFulfilledOn(LocalDate fulfilledOn) {
		this.fulfilledOn = fulfilledOn;
	}
	public List<Proposal> getProposals() {
		return proposals;
	}
	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}
	
	
	public Requirement(int reqId, boolean isFulfilled, LocalDate fulfilledOn, List<Proposal> proposals) {
		super();
		this.reqId = reqId;
		this.isFulfilled = isFulfilled;
		this.fulfilledOn = fulfilledOn;
		this.proposals = proposals;
	}
	
	
	public Requirement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Requirement(int resId, String title, String description, String category, LocalDate date, String type,
			double price, int empId) {
		super(resId, title, description, category, date, type, price, empId);
		// TODO Auto-generated constructor stub
	}
	public Requirement(int reqId2, boolean isFulfilled2, Date date, Proposal proposal) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Requirement [reqId=" + reqId + ", isFulfilled=" + isFulfilled + ", fulfilledOn=" + fulfilledOn
				+ ", proposals=" + proposals + "]";
	}
	
	
}
