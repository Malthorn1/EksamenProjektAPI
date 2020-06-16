/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.YogaClassDTO;
import entities.Course;
import entities.Instructor;
import entities.RenameMe;
import entities.SignedUp;
import entities.Student;
import entities.YogaClass;
import errorhandling.NotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

/**
 *
 * @author mikke
 */
public class YogaClassFacadeTest {

    private static EntityManagerFactory emf;
    private static YogaClassFacade facade;

    public YogaClassFacadeTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/dat3Eksamen_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        facade = YogaClassFacade.getFacadeExample(emf);
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
        emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.TEST, EMF_Creator.Strategy.DROP_AND_CREATE);
        facade = YogaClassFacade.getFacadeExample(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        
       
        
        try {
            

            em.getTransaction().begin();
            em.createNamedQuery("Instructor.deleteAllRows").executeUpdate();
            em.createNamedQuery("SignedUp.deleteAllRows").executeUpdate();
            em.createNamedQuery("Student.deleteAllRows").executeUpdate();
            em.createNamedQuery("YogaClass.deleteAllRows").executeUpdate();
            em.createNamedQuery("Course.deleteAllRows").executeUpdate();
             
        YogaClass Yoga1 = new YogaClass(20, "15/06-2020", 199);
        YogaClass Yoga2 = new YogaClass(20, "01/06-2020", 150);
        YogaClass Yoga3 = new YogaClass(20, "20/09-2020", 149);
        YogaClass Yoga4 = new YogaClass(20, "10/02-2020", 124);
        YogaClass Yoga5 = new YogaClass(20, "01/06-2020", 150);
        YogaClass Yoga6 = new YogaClass(20, "20/09-2020", 149);
        YogaClass Yoga7 = new YogaClass(20, "10/02-2020", 124);

        Course Course1 = new Course("Hot Yoga", "HOT");
        Course Course2 = new Course("Cold Yoga", "Cold");
        Course Course3 = new Course("Flexible Yoga", "Flexible");
        Course Course4 = new Course("Yoga", "Yoga");
        Instructor Insctructor1 = new Instructor("Lars");
        Instructor Insctructor2 = new Instructor("Thomas");
        SignedUp Signup1 = new SignedUp(true, "15/06-2020");
        SignedUp Signup2 = new SignedUp(true, "15/06-2020");
        SignedUp Signup3 = new SignedUp(true, "15/06-2020");
        SignedUp Signup4 = new SignedUp(true, "15/06-2020");
        SignedUp Signup5 = new SignedUp(true, "15/06-2020");

        Student Student1 = new Student("Karl", "22334455", "Karl@gmail.com");
        Student Student2 = new Student("Rasmus", "55555555", "Rasmus@gmail.com");
        Student Student3 = new Student("Mads", "99998888", "Mads@gmail.com");
        Student Student4 = new Student("Karsten", "12345678", "Karsten@gmail.com");
        Student Student5 = new Student("Peter", "00000000", "Peter@gmail.com");

        Signup1.addStudentToSignup(Student1);
        Signup1.addYogaClassToSignup(Yoga1);
        Signup2.addYogaClassToSignup(Yoga2);

        Signup2.addStudentToSignup(Student5);

        em.persist(Signup1);
        em.persist(Signup2);
        Yoga1.addCourseToYogaClass(Course1);
        Yoga1.addInstructorToYogaClass(Insctructor1);
        Yoga1.addInstructorToYogaClass(Insctructor2);

        Yoga2.addCourseToYogaClass(Course4);
        Yoga2.addInstructorToYogaClass(Insctructor2);

        Yoga3.addCourseToYogaClass(Course3);
        Yoga3.addInstructorToYogaClass(Insctructor1);

        Yoga4.addCourseToYogaClass(Course2);
        Yoga4.addInstructorToYogaClass(Insctructor2);

        Yoga5.addCourseToYogaClass(Course1);
        Yoga6.addCourseToYogaClass(Course1);
        Yoga7.addCourseToYogaClass(Course1);

            em.persist(Yoga1);
            em.persist(Yoga2);
            em.persist(Yoga3);
            em.persist(Yoga4);
            em.persist(Yoga5);
            em.persist(Yoga6);
            em.persist(Yoga7);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    @Test
    public void EditYogaClassTest() throws NotFoundException {
        YogaClass expectedClass = new YogaClass();
        
        YogaClass Yoga1 = new YogaClass(20, "15/06-2020", 199);
        YogaClassDTO yoDTO = new YogaClassDTO(Yoga1);

        YogaClassDTO result = facade.editYogaClass(yoDTO, 25);

    }

    // TODO: Delete or change this method 
    @Test
    public void CountYogaClassesTest() {
       long result = facade.CountYogaClasses(); 
       assertEquals(7, result); 
       
        //    assertEquals(2, facade.addYogaClass(YOGADTO), "Expects two rows in the database");
    }

}
