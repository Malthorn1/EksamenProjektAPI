/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "SignedUp.deleteAllRows", query = "DELETE from SignedUp")
public class SignedUp {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean payed;
    private String datePayed;
    
   

    @ManyToOne(cascade = {CascadeType.ALL})
    private Student student;
    
    
     @ManyToOne (cascade = {CascadeType.ALL})
     private YogaClass yogaClass; 

    public SignedUp() {
    }

    public SignedUp(Long id, boolean payed, String datePayed, Student student, YogaClass yogaClass) {
        this.id = id;
        this.payed = payed;
        this.datePayed = datePayed;
        this.student = student;
        this.yogaClass = yogaClass;
    }

    public SignedUp(boolean payed, String datePayed, Student student, YogaClass yogaClass) {
        this.payed = payed;
        this.datePayed = datePayed;
        this.student = student;
        this.yogaClass = yogaClass;
    }

    public SignedUp(boolean payed, String datePayed) {
        this.payed = payed;
        this.datePayed = datePayed;
    }
     
     
     
    public void addYogaClassToSignup (YogaClass yogaClass) {
        this.yogaClass = yogaClass; 
        if(!this.yogaClass.getSignUps().contains(this)) {
            yogaClass.getSignUps().add(this); 
        }
    }
    
      public void addStudentToSignup (Student student) {
        this.student = student; 
        if(!this.student.getSignUps().contains(this)) {
            student.getSignUps().add(this); 
        }
    }
     
     
     
     

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public String getDatePayed() {
        return datePayed;
    }

    public void setDatePayed(String datePayed) {
        this.datePayed = datePayed;
    }

   

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

 
   


    public YogaClass getYogaClass() {
        return yogaClass;
    }

    public void setYogaClass(YogaClass yogaClass) {
        this.yogaClass = yogaClass;
    }

     
     
     
     
     
}
