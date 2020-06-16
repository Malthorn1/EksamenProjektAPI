/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "Instructor.deleteAllRows", query = "DELETE from Instructor")
public class Instructor {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    
    @ManyToMany(mappedBy= "instructors", cascade = {CascadeType.ALL})
    private List<YogaClass> yogaClasses = new ArrayList(); 

    public Instructor() {
    }

    public Instructor(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Instructor(String name) {
        this.name = name;
    }

    
    public void addYogaClasssToInstructor (YogaClass yogaClasses) {
        if(!this.yogaClasses.contains(yogaClasses)) {
            this.yogaClasses.add(yogaClasses); 
        }
        if(!yogaClasses.getInstructors().contains(this)){
            yogaClasses.addInstructorToYogaClass(this);
        }
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

    public List<YogaClass> getYogaClasses() {
        return yogaClasses;
    }

    public void setYogaClasses(List<YogaClass> yogaClasses) {
        this.yogaClasses = yogaClasses;
    }
 
    
    
    
    
}
