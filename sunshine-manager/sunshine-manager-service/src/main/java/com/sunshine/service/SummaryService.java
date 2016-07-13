package com.sunshine.service;


public interface SummaryService {

	public Integer countUser();
	
	public Integer countOrder();
	
	public Integer countItems(Integer status);
	
	public Integer countNewClient();
	
}
