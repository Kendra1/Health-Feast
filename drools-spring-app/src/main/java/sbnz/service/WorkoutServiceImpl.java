package sbnz.service;

import java.util.List;

import org.springframework.stereotype.Service;

import sbnz.model.Workout;
import sbnz.repository.WokoutRepository;

@Service
public class WorkoutServiceImpl implements WorkoutService{

	private final WokoutRepository wokoutRepository;
	
	public WorkoutServiceImpl (WokoutRepository wokoutRepository) {
		this.wokoutRepository = wokoutRepository;
	}
	
	@Override
	public List<Workout> findAll() {
		return wokoutRepository.findAll();
	}

}
