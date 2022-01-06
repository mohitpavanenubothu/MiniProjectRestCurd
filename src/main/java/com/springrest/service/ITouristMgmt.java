package com.springrest.service;

import java.util.List;

import com.springrest.exception.TouristNotFoundException;
import com.springrest.model.Tourist;

public interface ITouristMgmt {

	public String registerTourist(Tourist tourist);

	public List<Tourist> findAllTourists();

	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException;

	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException;

	public String deleteTourist(Integer tid) throws TouristNotFoundException;

}
