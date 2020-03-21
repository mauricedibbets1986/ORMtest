package com.orm.demo.controller;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orm.demo.domein.Afdeling;


@Repository
public interface AfdelingRepository<T extends Afdeling> extends CrudRepository<T, Long> {
	
	Optional<T> findById(Long id);
	
}
