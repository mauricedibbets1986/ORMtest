package com.orm.demo.controller;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orm.demo.domein.*;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;

@Repository
public interface OpdrachtRepository extends CrudRepository<Opdracht, Long> {
	
}
