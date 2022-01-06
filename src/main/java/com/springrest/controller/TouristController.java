package com.springrest.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.model.Tourist;
import com.springrest.service.ITouristMgmt;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/tourist")
@Slf4j
public class TouristController {

	@Autowired
	private ITouristMgmt service;

	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist) {
		
		log.info("Inside enrollTourist method of TouristController");
		// RE contains body and status
		try {
			String result = service.registerTourist(tourist);
			return new ResponseEntity<String>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in tourist enrollment", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<?> displayTourists() {
		log.info("Inside displayTourists method of TouristController");
		try {
			List<Tourist> list = service.findAllTourists();
			return new ResponseEntity<List<Tourist>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in fetching Tourists", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayTouristById(@PathVariable("id") Integer id) {
		log.info("Inside displayTouristById method of TouristController");
		try {
			Tourist tourist = service.fetchTouristById(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("This not available in DB", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist) {
		log.info("Inside modifyTourist method of TouristController");
		// RE contains body and status
		try {
			String result = service.updateTouristDetails(tourist);
			return new ResponseEntity<String>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Problem in tourist enrollment", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeToursit(@PathVariable("id") Integer id) throws Exception {
		log.info("Inside removeToursit method of TouristController");
		// use service
		String msg = service.deleteTourist(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}// method

}
