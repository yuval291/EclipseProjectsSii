package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping("/all_car")
	public List<Car> getAllCar(){
		Car c1 = new Car("mazda","red", 45000, 2007, 1, 45000);
		carService.addCar(c1);
		return carService.getAllCar();
	}
	
	@PostMapping("/add_car")
	public ResponseEntity<Car> addCar(@RequestBody Car car) {
		try {
			return new ResponseEntity<Car>(carService.addCar(car), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Car>(HttpStatus.BAD_REQUEST);
		}		
	}
	
	@PostMapping("/add_cars")
	public ResponseEntity<List<Car>> addCars(@RequestBody List<Car> cars) {
		try {
			return new ResponseEntity<List<Car>>(carService.addCars(cars), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<Car>>(HttpStatus.BAD_REQUEST);
		}	
	}
	
	@DeleteMapping("/delete_car")
	public ResponseEntity<Boolean> deleteCar(@RequestBody Car car){
		try {
			return new ResponseEntity<Boolean>(carService.deleteCar(car), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Boolean>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/update_car")
	public ResponseEntity<Car> updateCar(@RequestBody Car car) {
		try {
			return new ResponseEntity<Car>(carService.updateCar(car), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Car>(HttpStatus.BAD_REQUEST);
		}		
	}

	@GetMapping("/searchByPrice/{min}/{max}")
	public ResponseEntity<List<Car>> searchByPrice(@PathVariable int min,@PathVariable int max){
		try {
			return new ResponseEntity<List<Car>>(carService.searchByPrice(min, max), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<Car>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/searchByYearOfManufacture/{minYear}/{maxYear}")
	public ResponseEntity<List<Car>> searchByYearOfManufacture(@PathVariable int minYear,@PathVariable int maxYear){
		try {
			return new ResponseEntity<List<Car>>(carService.searchByYearOfManufacture(minYear, maxYear), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<Car>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/searchByMileageAbove/{mileage}")
	public ResponseEntity<List<Car>> searchByMileageAbove(@PathVariable long mileage){
		try {
			return new ResponseEntity<List<Car>>(carService.searchByMileageAbove(mileage), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<Car>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/searchByMileageBelow/{mileage}")
	public ResponseEntity<List<Car>> searchByMileageBelow(@PathVariable long mileage){
		try {
			return new ResponseEntity<List<Car>>(carService.searchByMileageBelow(mileage), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<Car>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/searchByColor/{color}")
	public ResponseEntity<List<Car>> searchByColor(@PathVariable String color){
		try {
			return new ResponseEntity<List<Car>>(carService.searchByColor(color), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<Car>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/searchByNumberOfPreviousOwners/{owners}")
	public ResponseEntity<List<Car>> searchByNumberOfPreviousOwners(@PathVariable int owners){
		try {
			return new ResponseEntity<List<Car>>(carService.searchByNumberOfPreviousOwners(owners), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<List<Car>>(HttpStatus.BAD_REQUEST);
		}
	}

}
