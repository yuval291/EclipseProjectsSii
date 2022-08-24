package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SysRepo extends CrudRepository<Systems, String>{

	List<Systems> findAllByOrderByResponseCode();

}
