package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Car;

public interface CarRepository extends JpaRepository<Car, String>{
	
	@Query(value = "select * from car where price between ?1 and ?2", nativeQuery = true)
	public List<Car> getCarByPrice(int min, int max);

	@Query(value = "select * from car where year_of_manufacture between ?1 and ?2", nativeQuery = true)
	public  List<Car>  getCarByRangOfYear(int minYear, int maxYear);

	public List<Car> findByMileageGreaterThan(long above);

	public List<Car> findByMileageLessThan(long i);

	public List<Car> findAllByColor(String color);

	public List<Car> findAllByNumberOfPreviousOwners(int i);

}
