package com.orm.demo.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orm.demo.domein.Afdeling;


@Repository
public interface AfdelingRepository extends CrudRepository<Afdeling, Long> {}
