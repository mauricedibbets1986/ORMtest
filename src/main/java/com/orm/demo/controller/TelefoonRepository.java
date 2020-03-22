package com.orm.demo.controller;

import com.orm.demo.domein.*;
import com.orm.demo.controller.*;
import com.orm.demo.rest.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.orm.demo.domein.Persoon;

@Repository
public interface TelefoonRepository extends CrudRepository<Telefoon, Long> {}