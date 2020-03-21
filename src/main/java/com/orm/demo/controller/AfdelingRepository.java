package com.orm.demo.controller;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orm.demo.domein.Afdeling;


@Repository
public interface AfdelingRepository<Afdeling> extends CrudRepository<Afdeling, Long> {
	Afdeling findById(long id);
}
