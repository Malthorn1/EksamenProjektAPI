/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.YogaClassDTO;
import entities.Course;
import entities.YogaClass;
import errorhandling.NotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mikke
 */
public class YogaClassFacade {
     private static EntityManagerFactory emf;
    private static YogaClassFacade instance;

    public YogaClassFacade() {
    }

    public static YogaClassFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new YogaClassFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
        public Long CountYogaClasses() {
        EntityManager em = emf.createEntityManager();
        try {
            long courseCount = (long) em.createQuery("SELECT  COUNT(r) FROM YogaClass r").getSingleResult();
           return courseCount;  
        }
        finally {
            em.close();
        }
    }
    
    
    

    public YogaClassDTO addYogaClass(YogaClassDTO YOGADTO) throws NotFoundException {
          EntityManager em = emf.createEntityManager();
          YogaClass YogaCLass = new YogaClass (YOGADTO);
          Course Course = new Course(); 
          
        try{
            em.getTransaction().begin();
            Course = em.find(Course.class, YOGADTO.getCourseID()); 
            
            YogaCLass.addCourseToYogaClass(Course);
            em.merge(YogaCLass);
            em.getTransaction().commit();
        }finally{
            em.close();
            
        }
        YogaClassDTO yoga = new YogaClassDTO(YogaCLass); 
        return yoga;
    }

    public YogaClassDTO editYogaClass(YogaClassDTO YOGADTO, int value) throws NotFoundException {
                EntityManager em = getEntityManager();
                Course Course = new Course(); 
        try {
            em.getTransaction().begin();
   
            Course = em.find(Course.class, YOGADTO.getCourseID()); 
            YogaClass yoga = em.find(YogaClass.class, (long) value);
            if (yoga == null) {
                throw new NotFoundException("No YogaClass found");
            }
            yoga.setMaxParticipants(YOGADTO.getMaxParticipants());
            yoga.setPrice(YOGADTO.getPrice());
            yoga.setStartDate(YOGADTO.getStartDate());

            
            yoga.EditYogaClassCourse(Course);
            em.merge(yoga); 
            em.getTransaction().commit();
            return new YogaClassDTO(yoga);
        } finally {
            em.close();
        }
    }

    public YogaClassDTO deleteYogaClass(YogaClassDTO YOGADTO) {
            EntityManager em = getEntityManager();
            
            try {
                em.getTransaction().begin();
            }
    }
        
    }
    
    

    

