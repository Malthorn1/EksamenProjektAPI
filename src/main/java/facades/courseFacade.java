/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.CourseDTO;
import dtos.CoursesDTO;
import dtos.YogaClassDTO;
import entities.Course;
import entities.YogaClass;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;


public class courseFacade {

    private static EntityManagerFactory emf;
    private static courseFacade instance;

    public courseFacade() {
    }

    public static courseFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new courseFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public Long CountCourses() {
        EntityManager em = emf.createEntityManager();
        try {
            long courseCount = (long) em.createQuery("SELECT  COUNT(r) FROM Course r").getSingleResult();
           return courseCount;  
        }
        finally {
            em.close();
        }
    }
    

    public List<CourseDTO> getUniqueCourses() {
        EntityManager em = emf.createEntityManager();
        try {
            List<CourseDTO> cSDTO = new ArrayList();
            List<YogaClassDTO> yogaDTO = new ArrayList();
            
            
               TypedQuery<Course> q = em.createQuery("select c from Course c", Course.class) ; 
               for (Course c : q.getResultList()) {
                   
                   for (YogaClass yc : c.getYogaClasses()) {
                       yogaDTO.add(new YogaClassDTO (yc)); 
                   }
                   CourseDTO cDTO = new CourseDTO(c);
                   cDTO.setYogaClass(yogaDTO);
                   cSDTO.add(cDTO); 
               }
               return cSDTO; 
        }finally {
            em.close(); 
//               
//               
//               List<YogaClass> query = em.createQuery("select y from YogaClass y join y.course c where c.id =:id").setParameter("id", i).getResultList();
//                       
//         //  long courseCount = (long) em.createQuery("SELECT  COUNT(r) FROM Course r").getSingleResult();
//        //    List<YogaClassDTO> yList = new ArrayList();
//         //   CourseDTO CombiDTO = new CourseDTO(); 
//            
//         
//
//            
//            for (Course c :)
//            
//            
//            
//             CoursesDTO finalDTO = new CoursesDTO();
//            for (int i = 1; i < courseCount + 1; i++) {
//                Course c = em.find(Course.class, (long) i);
//                //Course cDTO = new Course(c);
//                //List<YogaClass> query = em.createQuery("select * from YOGACLASS where COURSE_ID = 1").getResultList(); 
//                
//                
//                
//              //  yogaDTO = em.createQuery("SELECT y FROM YogaClass y").getResultList();
//
////                for (int j = 0; j < query.size(); j++) {
////                    YogaClass y = em.find(YogaClass.class, query.get(j).getCourse().getId());
////                    System.out.println(query.get(j).getCourse().getId()));
////                    YogaClassDTO yDTO = new YogaClassDTO(y);
////
////                    if (y.getCourse().getId() == cDTO.getId()) {
////                         yList.add(yDTO);
////
//////                        System.out.println(yList.get(0).getInstructors());
////                    }
////                }
//                //  System.out.println(yList.get(i - 1).getPrice());
//                
//                //  cSDTO.add(cDTO,yList); 
//                // cSDTO.add(cDTO,yList); 
//
////                System.out.println(query.get(0).getPrice());
//                //cSDTO.add(cDTO); 
//                System.out.println(c.getCourseName());
//                System.out.println(query.get(0).getPrice());
//            CombiDTO = new CourseDTO(c, query); 
//            
//            finalDTO.addCourses(CombiDTO);
//            }
//            
//            System.out.println(finalDTO.getCourses().get(0).getCourseName());
//            System.out.println(finalDTO.getYogaClasses().get(0).getPrice()); 
//            
//
//           
//            System.out.println(finalDTO.getCourses().get(0).getCourseName());
////            System.out.println(finalDTO.getYogaClasses().get(0).getPrice());
//            System.out.println(finalDTO.getCourses().get(1).getCourseName());
////            System.out.println(finalDTO.getYogaClasses().get(1).getPrice());
//            System.out.println(finalDTO.getCourses().get(2).getCourseName());
////            System.out.println(finalDTO.getYogaClasses().get(2).getPrice());
//            System.out.println(finalDTO.getCourses().get(3).getCourseName());
////            System.out.println(finalDTO.getYogaClasses().get(3).getPrice());
//
//            return CombiDTO;
//        } finally {
//            em.close();
        }

    }

}
