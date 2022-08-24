package com.example.demo.quartz;

import java.util.List;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Systems;

@org.springframework.stereotype.Repository
public interface SystemRepository extends JpaRepository<Systems, String>{	
	
	@Cacheable("systemDb")
	List<Systems> findAll();
}