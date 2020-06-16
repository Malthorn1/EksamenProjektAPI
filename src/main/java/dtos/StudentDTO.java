/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.SignedUp;
import entities.Student;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mikke
 */
public class StudentDTO {
    
    private String name;
    private String phone;
    private String email;
    private List<SignedUp> signUps = new ArrayList();  
    

    public StudentDTO() {
    }

    public StudentDTO(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public StudentDTO(Student student) {
        this.name = student.getName();
        this.phone = student.getPhone();
        this.email = student.getEmail();
    }
    
    
    public StudentDTO(Student student, List<SignedUp> signUps) {
        this.name = student.getName();
        this.phone = student.getPhone();
        this.email = student.getEmail();
        this.signUps = signUps;  

        }
    }
