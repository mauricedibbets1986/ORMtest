package com.orm.demo.controller;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orm.demo.domein.Afdeling;
import com.orm.demo.domein.Persoon;

@Repository
public interface PersoonRepository extends CrudRepository<Persoon, Long> {
    Optional<Persoon> findById(Long id);

    Persoon[] findAllById(Long id);
	
}
