/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Course;
import entities.YogaClass;
import java.util.List;

/**
 *
 * @author mikke
 */
public class CourseDTO {

    private Long id;
    private String courseName;
    private String description;
    private List<YogaClassDTO> yogaClass;

    public CourseDTO() {
    }

    public CourseDTO(String courseName, String description) {
        this.courseName = courseName;
        this.description = description;
    }
    
       public CourseDTO(Course c) {
        this.id = c.getId(); 
        this.courseName = c.getCourseName();
        this.description = c.getDescription();
    }
//
//    public CourseDTO(Course course, List<YogaClass> yogaClass) {
//        this.courseName = course.getCourseName();
//        this.description = course.getDescription();
//        this.yogaClass = yogaClass;
//    }
//
//    public List<YogaClass> getYogaClass() {
//        return yogaClass;
//    }

    public void setYogaClass(List<YogaClassDTO> yogaClass) {
        this.yogaClass = yogaClass;
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


}
