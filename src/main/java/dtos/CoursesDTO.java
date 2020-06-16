/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.YogaClass;
import java.util.ArrayList;
import java.util.List;


public class CoursesDTO {
    private List<CourseDTO> courses; 
    private List<YogaClassDTO> yogaClasses; 
    

    public CoursesDTO() {
    }

    public CoursesDTO(List<CourseDTO> courses) {
        this.courses = courses;
    }

//      public CoursesDTO( List<YogaClassDTO> yogaClasses) {
//        this.yogaClasses = yogaClasses;
//    }
    
    
    public void addCourses(CourseDTO CourseDTO) {
        this.courses.add(CourseDTO);
     
    }
    
    
    
    
    
    public CoursesDTO(List<CourseDTO> courses, List<YogaClassDTO> yogaClasses) {
        this.courses = courses;
        this.yogaClasses = yogaClasses;
    }

    public List<YogaClassDTO> getYogaClasses() {
        return yogaClasses;
    }

    public void setYogaClasses(List<YogaClassDTO> yogaClasses) {
        this.yogaClasses = yogaClasses;
    }
    

    public List<CourseDTO> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDTO> courses) {
        this.courses = courses;
    }
    
    
    
    
}
