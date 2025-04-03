package com.gerendePets.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerendePets.Entity.Pets;

public interface PetsRepository extends JpaRepository <Pets, Long> {

}
