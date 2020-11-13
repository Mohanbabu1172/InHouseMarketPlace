package com.cg.InHouseMarketPlace.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.InHouseMarketPlace.exception.InvalidOfferException;
import com.cg.InHouseMarketPlace.model.Offer;
import com.cg.InHouseMarketPlace.service.OfferService;

@RestController
public class OfferController {
	@Autowired
	private OfferService offerService;
	/*
	 * Adding an offer
	 */
	@PostMapping("/addoffer")
	public Offer addOffer(@RequestBody Offer offer)
	{
		return offerService.addOffer(offer);
	}
	/*
	 * updating an offer
	 */
	@PutMapping("/updateoffer")
	public Offer updateOffer(@RequestBody Offer offer)
	{
		return offerService.editOffer(offer);
	}
	/*
	 * getting offer by offer Id
	 */
	@GetMapping("/getoffer/{offerId}")
	public ResponseEntity<Offer> getOfferById(@PathVariable int offerId){
		Offer fetchedOffers = offerService.getOffer(offerId);
		if(fetchedOffers.getOfferId()==0) {
			throw new InvalidOfferException("No Offers found with id= : " + offerId);
		}
		else {
			return new ResponseEntity<Offer>(fetchedOffers,HttpStatus.OK);
		}
	}
	/*
	 * deleting offer by offerId
	 */
	@DeleteMapping("/deleteoffer/{offerId}")
	public ResponseEntity<Offer> deleteOfferById(@PathVariable int offerId ){
		Offer OfferAvailable = offerService.getOffer(offerId);
		if(OfferAvailable.getOfferId()==0) {
			throw new InvalidOfferException("No Offers found with id : " + offerId);
		}
		else {
			offerService.removeOffer(offerId);
			return new ResponseEntity<Offer>(HttpStatus.OK);
		}
	}
	/*
	 * getting all offers
	 */
	@GetMapping("/getalloffers")
	public List<Offer> getAllOffers()
	{
		return offerService.getAllOffers();
	}
	/*
	 * getting all offers by category and type in employee
	 */
	@GetMapping("/getOffers")
	public List<Offer> getAllOffers(@RequestParam(value="category") String category,@RequestParam(value="type") String type){
		return offerService.getAllOffers(category, type);
	}
}