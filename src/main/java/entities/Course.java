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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author mikke
 */
@Entity
@NamedQuery(name = "Course.deleteAllRows", query = "DELETE from Course")
public class Course {
    
        private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName; 
    private String description; 

    
    @OneToMany (mappedBy ="course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<YogaClass> yogaClasses = new ArrayList<>(); 
    
    public Course() {
    }

    public Course(Long id, String courseName, String description) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
    }

    public Course(String courseName, String description) {
        this.courseName = courseName;
        this.description = description;
    }

    
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<YogaClass> getYogaClasses() {
        return yogaClasses;
    }

    public void setYogaClasses(List<YogaClass> yogaClasses) {
        this.yogaClasses = yogaClasses;
    }
    
    
    
    

    
}
