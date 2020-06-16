/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Instructor;
import entities.YogaClass;
import java.util.List;

/**
 *
 * @author mikke
 */
public class InstructorDTO {

    private Long id;
    private String name;
    private List<YogaClass> yogaClass; 

    public InstructorDTO() {
    }

    public InstructorDTO(Instructor insctuctor, List<YogaClass> yogaClass) {
        this.id = insctuctor.getId();
        this.name = insctuctor.getName();
        this.yogaClass = yogaClass;
    }

    public InstructorDTO(Long id, String name, List<YogaClass> yogaClass) {
        this.id = id;
        this.name = name;
        this.yogaClass = yogaClass;
    }

    public InstructorDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public InstructorDTO(Instructor instructor) {
        this.name = instructor.getName();
    }
    

    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<YogaClass> getYogaClass() {
        return yogaClass;
    }

    public void setYogaClass(List<YogaClass> yogaClass) {
        this.yogaClass = yogaClass;
    }

    
    
}

