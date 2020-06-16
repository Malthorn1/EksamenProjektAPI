/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Course;
import entities.Instructor;
import entities.SignedUp;
import entities.YogaClass;
import java.util.List;


public class YogaClassDTO {
    private Long id;
    private int maxParticipants; 
    private String startDate; 
    private int price; 
    private List<Instructor> instructor; 
    private Course course; 
    private long courseID; 
    private List<SignedUp> signUps; 

    public YogaClassDTO() {
    }


    public YogaClassDTO(YogaClass YogaClass) {
        this.id = YogaClass.getId(); 
        this.maxParticipants = YogaClass.getMaxParticipants(); 
        this.startDate = YogaClass.getStartDate();
        this.price = YogaClass.getPrice();
        this.instructor = YogaClass.getInstructors();
     //   this.course = YogaClass.getCourse();
        this.signUps = YogaClass.getSignUps();
        
    }



    
    
    
    
    
    
    
    public long getCourseID() {
        return courseID;
    }

    public void setCourseID(long courseID) {
        this.courseID = courseID;
    }
        
        

    
    
    
    
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Instructor> getInstructor() {
        return instructor;
    }

    public void setInstructor(List<Instructor> instructor) {
        this.instructor = instructor;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<SignedUp> getSignUps() {
        return signUps;
    }

    public void setSignUps(List<SignedUp> signUps) {
        this.signUps = signUps;
    }
    

    
}

