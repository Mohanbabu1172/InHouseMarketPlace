package com.cg.InHouseMarketPlace.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cg.InHouseMarketPlace.model.Employee;
import com.cg.InHouseMarketPlace.model.Offer;
import com.cg.InHouseMarketPlace.model.Proposal;
import com.cg.InHouseMarketPlace.model.Resource;
import com.cg.InHouseMarketPlace.model.User;

@ExtendWith(MockitoExtension.class)
class OfferServiceTest {

OfferService offerService=mock(OfferService.class);
User user=new User("123","Bhanu");
Employee emp=new Employee(1,"bhanu","mca","AP",user);
Resource res=new Resource(12,"title","description","category",LocalDate.now(),"type",0.2f,1);
Proposal pro=new Proposal(10,"hii",0.2f,LocalDate.now(),true,LocalDate.now(),emp,res);
Offer offer1=new Offer(11,true,LocalDate.now(),pro);
Offer offer2=new Offer(15,false,LocalDate.now(),pro);

@Test
void addOffer() {
	when(offerService.addOffer(offer1)).thenReturn(offer1);
	assertEquals(offer1,offerService.addOffer(offer1));
}
@Test
void editOffer()
{
	when(offerService.editOffer(offer1)).thenReturn(offer1);
	assertEquals(offer1,offerService.editOffer(offer1));
}
@Test
void getOffer() {
	
	when(offerService.getOffer(offer1.getOfferId())).thenReturn(offer1);
	assertEquals(offer1,offerService.getOffer(offer1.getOfferId()));
}
@Test
void removeOffer() {
	when(offerService.removeOffer(11)).thenReturn(offer1);
	assertEquals(offer1,offerService.removeOffer(11));
}
@Test
void getAllAsList() {
	List<Offer> offers=new ArrayList<Offer>();
	offers.add(offer1);
	offers.add(offer2);
	when(offerService.getAllOffers()).thenReturn(offers);
	assertEquals(offers,offerService.getAllOffers());	
}
@Test
 void testGetAllResources()
{
	List<Offer> offers=new ArrayList<Offer>();
	
	offers.add(offer1);
	offers.add(offer2);
	
	when(offerService.getAllOffers("categor", "typ")).thenReturn(offers);
	List<Offer> resultList=offerService.getAllOffers("categor", "typ");
	
	assertNotNull(resultList);
	
	assertEquals(resultList.size(), offers.size());
}
}
