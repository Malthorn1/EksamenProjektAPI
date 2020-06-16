/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Student;
import entities.YogaClass;

/**
 *
 * @author mikke
 */
public class SignUpDTO {
    private boolean payed;
    private String datePayed;
    private YogaClass yogaClass; 
    private Student student; 

    public SignUpDTO() {
    }

    
    
    public SignUpDTO(boolean payed, String datePayed, YogaClass yogaClass, Student student) {
        this.payed = payed;
        this.datePayed = datePayed;
        this.yogaClass = yogaClass;
        this.student = student;
    }

    public SignUpDTO(boolean payed, String datePayed) {
        this.payed = payed;
        this.datePayed = datePayed;
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

    public YogaClass getYogaClass() {
        return yogaClass;
    }

    public void setYogaClass(YogaClass yogaClass) {
        this.yogaClass = yogaClass;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
    
    
    
    
    
}
