package com.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.exception.TouristNotFoundException;
import com.springrest.model.Tourist;
import com.springrest.repo.ITouristRepo;

import lombok.extern.slf4j.Slf4j;

@Service("touristService")
@Slf4j
public class TouristMgmtServiceImpl implements ITouristMgmt {

	@Autowired
	private ITouristRepo touristRepo;

	@Override
	public String registerTourist(Tourist tourist) {
		log.info("Inside registerTourist method of TouristMgmtServiceImpl class");
		int idVal = touristRepo.save(tourist).getTid();
		return "Tourist is registered having the id value::" + idVal;
	}

	@Override
	public List<Tourist> findAllTourists() {
		log.info("Inside findAllTourists method of TouristMgmtServiceImpl class");
		List<Tourist> list = touristRepo.findAll();
		list.sort((t1, t2) -> t1.getTid().compareTo(t2.getTid()));
		return list;
	}

	@Override
	public Tourist fetchTouristById(Integer tid) throws TouristNotFoundException {
		log.info("Inside fetchTouristById method of TouristMgmtServiceImpl class");
		return touristRepo.findById(tid).orElseThrow(() -> new TouristNotFoundException(tid + "tourist not found"));
	}

	@Override
	public String updateTouristDetails(Tourist tourist) throws TouristNotFoundException {
		log.info("Inside updateTouristDetails method of TouristMgmtServiceImpl class");
		Optional<Tourist> optional = touristRepo.findById(tourist.getTid());
		if (optional.isPresent()) {
			touristRepo.save(tourist);
			return tourist.getTid() + "Tourist is updated";
		} else {
			throw new TouristNotFoundException(tourist.getTid() + "Tourist not found");
		}

	}

	@Override
	public String deleteTourist(Integer tid) throws TouristNotFoundException {
		log.info("Inside deleteTourist method of TouristMgmtServiceImpl class");
		Optional<Tourist> opt = touristRepo.findById(tid);
		if (opt.isPresent()) {
			touristRepo.delete(opt.get());
			return tid + " Tourist deleted";
		} else {
			throw new TouristNotFoundException(tid + " Tourist not found ");
		}

	}

}
