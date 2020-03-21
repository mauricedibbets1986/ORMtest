package com.orm.demo.controller;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orm.demo.domein.*;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;


@Repository
public interface AfdelingRepository<IdType extends Serializable> extends CrudRepository<Afdeling, Long> {
	
	Afdeling findById(long afdelingId);
	
}
