package com.example.demo.repo;

import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Systems;

@org.springframework.stereotype.Repository
public interface SystemRepository<T extends Systems> extends JpaRepository<T,String>{	
	
	@Cacheable("systemDb")
	List<T> findAll();
}