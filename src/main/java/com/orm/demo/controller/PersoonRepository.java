package com.orm.demo.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orm.demo.domein.Persoon;

@Repository
public interface PersoonRepository extends CrudRepository<Persoon, Long> {}
