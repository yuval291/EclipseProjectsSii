package com.example.demo;
 
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
 
@Service
public class StudentService 
{
  @Cacheable("student")
  public Student getStudentByID(String id) 
  {
	  System.out.println("11111");
    try
    {
      System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
      Thread.sleep(1000*5);
    } 
    catch (InterruptedException e) 
    {
      e.printStackTrace();
    }
 
    return new Student(id,"Sajal" ,"V");
  }
}