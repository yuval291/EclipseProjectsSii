package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Car;
import com.example.demo.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepo;

	public List<Car> getAllCar() {
		return carRepo.findAll();
	}

	public Car addCar(Car c) {
		return carRepo.save(c);
	}

	public List<Car> addCars(Car...cars) {
		List<Car> carList = Arrays.asList(cars);
		return carRepo.saveAll(carList);
	}
	
	public List<Car> addCars(List<Car> cars) {
		return carRepo.saveAll(cars);
	}

	public boolean deleteCar(Car c) {
		carRepo.delete(c);
		if(carRepo.findById(c.getCarType()).isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void deleteCars(Car...cars) {
		List<Car> carList = Arrays.asList(cars);
		carRepo.deleteAll(carList);
	}

	public Car updateCar(Car c1) {
		return carRepo.save(c1);
	}
	
	public List<Car> searchByPrice (int min , int max) {
		return carRepo.getCarByPrice( min ,  max);
	}
	
	public List<Car> searchByYearOfManufacture(int minYear , int maxYear) {
		return carRepo.getCarByRangOfYear( minYear ,  maxYear);
	}

	public List<Car> searchByMileageAbove(long above) {
		return carRepo.findByMileageGreaterThan(above);
	}

	public List<Car> searchByMileageBelow(long i) {
		return carRepo.findByMileageLessThan(i);
	}

	public List<Car> searchByColor(String color) {
		return carRepo.findAllByColor(color);
	}

	public List<Car> searchByNumberOfPreviousOwners(int i) {
		return carRepo.findAllByNumberOfPreviousOwners(i);
	}




}
