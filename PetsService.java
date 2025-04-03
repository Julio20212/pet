package com.gerendePets.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gerendePets.Entity.Pets;
import com.gerendePets.Repository.PetsRepository;

@Service
public class PetsService {

	private final PetsRepository petsRepository;

	@Autowired
	public  PetsService(PetsRepository petsRepository) {
		this.petsRepository = petsRepository;
	}

	public List <Pets> getAllPets() {
		return petsRepository.findAll();
	}
	
	public Pets getPetsById(Long id) {
		Optional<Pets> pets = petsRepository.findById(id);
		return pets.orElse(null);
	}
	
	public Pets salvarPets ( Pets pets) {
		return petsRepository.save(pets);
		
	}
	
	public Pets updatePets(Long id, Pets updatedPets) {
		Optional<Pets> existingPets = petsRepository.findById(id);
		if (existingPets.isPresent()) {
			updatedPets.setId(id);
			return petsRepository.save(updatedPets);
		}
		return null;
	}

	public boolean deletePets(Long id) {
		Optional<Pets> existingPets = petsRepository.findById(id);
		if (existingPets.isPresent()) {
			petsRepository.deleteById(id);
			return true;
		}
		return false;
	}
}