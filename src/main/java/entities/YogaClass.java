/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.YogaClassDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


@Entity 
@NamedQuery(name = "YogaClass.deleteAllRows", query = "DELETE from YogaClass")
public class YogaClass {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int maxParticipants; 
    private String startDate; 
    private int price; 
    
    @ManyToMany(cascade = {CascadeType.ALL})
    private List<Instructor> instructors = new ArrayList(); 
    
     @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private Course course;

    @OneToMany (mappedBy ="yogaClass", cascade = CascadeType.ALL)
    private List<SignedUp> signUps = new ArrayList<>(); 
     
     
    public YogaClass() {
    }

    public YogaClass(Long id, int maxParticipants, String startDate, int price, Course course) {
        this.id = id;
        this.maxParticipants = maxParticipants;
        this.startDate = startDate;
        this.price = price;
        this.course = course;
    }
    
    public YogaClass (YogaClassDTO YogaClassDTO) {
        this.maxParticipants = YogaClassDTO.getMaxParticipants();
        this.startDate = YogaClassDTO.getStartDate();
        this.price = YogaClassDTO.getPrice();
        this.course = YogaClassDTO.getCourse(); 
        
    }
    
    

    public YogaClass(int maxParticipants, String startDate, int price, Course course) {
        this.maxParticipants = maxParticipants;
        this.startDate = startDate;
        this.price = price;
        this.course = course;
    }

    public YogaClass(int maxParticipants, String startDate, int price) {
        this.maxParticipants = maxParticipants;
        this.startDate = startDate;
        this.price = price;
    }
    
       public void addCourseToYogaClass (Course course) {
        this.course = course; 
        if(!course.getYogaClasses().contains(this)) {
            course.getYogaClasses().add(this); 
        }
    }
       
       public void EditYogaClassCourse (Course course) {
           this.course.setCourseName(course.getCourseName());
           this.course.setDescription(course.getDescription());
           this.course.setId(course.getId());
           
           
       }
       
    public void addInstructorToYogaClass (Instructor instructor) {
        if(!this.instructors.contains(instructor)) {
            this.instructors.add(instructor); 
        }
        if (!instructor.getYogaClasses().contains(this)) {
            instructor.getYogaClasses().add(this); 
        }
    }
    
     public void addSignUpToYogaClass (SignedUp signUp) {
        if(!this.signUps.contains(signUp)) {
            //this.signUps.add(signUp); 
        }
        if (!signUp.getYogaClass().equals(this)) {
            signUp.setYogaClass(this); 
        }
    }

    public List<SignedUp> getSignUps() {
        return signUps;
    }

    public void setSignUps(List<SignedUp> signUps) {
        this.signUps = signUps;
    }
    
    
    
    
    
    
    

     
     
     
     
     
     
     
     
     
     
     
     
     
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public void setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

 

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(List<Instructor> instructors) {
        this.instructors = instructors;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
     
     
     
}
