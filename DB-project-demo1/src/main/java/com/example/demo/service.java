package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service{
//	
//	 @Autowired
//	 private repo repo;
	 
	 @Autowired
	 private SysRepo sysRepo;
	 
//	 public void getBooks() {
//		 
//		 List<book> books = (List<book>) repo.findAll();
//		 
//		 System.out.println(books.get(0).getFullname());
//	}
	 
	 public void getSystems() {
		 
		 List<Systems> systems = (List<Systems>) sysRepo.findAllByOrderByResponseCode();
		 
		 System.out.println(systems.get(0).getName()+" - "+systems.get(0).getUrl()+" "+ systems.get(0).getResponseCode());
		 System.out.println(systems.get(1).getName()+" - "+systems.get(1).getUrl()+" "+ systems.get(1).getResponseCode());
		 System.out.println(systems.get(2).getName()+" - "+systems.get(2).getUrl()+" "+ systems.get(2).getResponseCode());
		 System.out.println(systems.get(3).getName()+" - "+systems.get(3).getUrl()+" "+ systems.get(3).getResponseCode());
		 System.out.println(systems.get(4).getName()+" - "+systems.get(4).getUrl()+" "+ systems.get(4).getResponseCode());
		 
		 Date date = new Date();
		 Systems s = new Systems("gogo//google.com","blabla bla", date, 950);
		 
		 sysRepo.save(s);
	
	}
	
}