package com.cg.InHouseMarketPlace.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.InHouseMarketPlace.model.Offer;
import com.cg.InHouseMarketPlace.repository.OfferRepository;

@Service
public class OfferService {
	
	@Autowired
	private OfferRepository offerRepository;
	
	/*
	 * Adding an offer
	 */
	public Offer addOffer(Offer offer) {
		
		return offerRepository.save(offer);	
	}
	/*
	 * updating an offer
	 */
	public Offer editOffer(Offer offer) 
	{
		if(offerRepository.findById(offer.getOfferId())!=null) 
		{
			return offerRepository.save(offer);
		}
		
		      else 
		   {
			   return null;
		   }
	}
	
	/*
	 * getting offer by offer Id
	 */
	public Offer getOffer(int offerId)
	{
		return offerRepository.findById(offerId).orElse(new Offer());
	}
	
	/*
	 * deleting offer by offerId
	 */
	public Offer removeOffer(int offerId)
	{
		offerRepository.deleteById(offerId);
	    return null;
	}
	
	/*
	 * getting all offers
	 */
	public List<Offer> getAllOffers() 
	{
		return (List<Offer>) offerRepository.findAll();
	}
	
	/*
	 * getting all offers by category and type in employee
	 */
    public List<Offer> getAllOffers(String category, String type) {
	return offerRepository.findByCategoryAndType(category, type);
}
	
}