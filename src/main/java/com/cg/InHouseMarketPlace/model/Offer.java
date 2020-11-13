package com.cg.InHouseMarketPlace.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
@Entity
public class Offer extends Resource {
	private int offerId;
	private boolean isAvailable;
	private LocalDate availableUpto;
	@OneToMany
	private List<Proposal> proposals;
	
	public int getOfferId() {
		return offerId;
	}
	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public LocalDate getAvailableUpto() {
		return availableUpto;
	}
	public void setAvailableUpto(LocalDate availableUpto) {
		this.availableUpto = availableUpto;
	}
	public List<Proposal> getProposals() {
		return proposals;
	}
	public void setProposals(List<Proposal> proposals) {
		this.proposals = proposals;
	}
		
	public Offer(int i, boolean b, LocalDate localDate, Proposal pro) {
		super();
		// TODO Auto-generated constructor stub
	}
	public Offer(int resId, String title, String description, String category, LocalDate date, String type,
			double price, int empId) {
		super(resId, title, description, category, date, type, price, empId);
		// TODO Auto-generated constructor stub
	}
	public Offer() {
		// TODO Auto-generated constructor stub
	}
	public Offer(int i, boolean b, LocalDate now, List<Proposal> proposalList) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Offer [offerId=" + offerId + ", isAvailable=" + isAvailable + ", availableUpto=" + availableUpto
				+ ", proposals=" + proposals + "]";
	}
	
	
}
