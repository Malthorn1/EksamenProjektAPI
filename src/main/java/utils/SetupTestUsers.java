package utils;

import entities.Course;
import entities.Instructor;
import entities.Role;
import entities.SignedUp;
import entities.Student;
import entities.User;
import entities.YogaClass;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

    public static void main(String[] args) {

        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
        EntityManager em = emf.createEntityManager();

        // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
        // CHANGE the three passwords below, before you uncomment and execute the code below
        // Also, either delete this file, when users are created or rename and add to .gitignore
        // Whatever you do DO NOT COMMIT and PUSH with the real passwords
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

        // Course1.addYogaClassesToCourse(Yoga1);
        User user = new User("user", "test123");
        User admin = new User("admin", "test123");
        User both = new User("user_admin", "test123");

        if (admin.getUserPass().equals("test") || user.getUserPass().equals("test") || both.getUserPass().equals("test")) {
            throw new UnsupportedOperationException("You have not changed the passwords");
        }

        em.getTransaction().begin();

        //Signup1.addStudentToSignup(Student1);
        Signup1.addStudentToSignup(Student1);
        Signup1.addYogaClassToSignup(Yoga1);
        Signup2.addYogaClassToSignup(Yoga2);

        Signup2.addStudentToSignup(Student5);

        em.persist(Signup1);
        em.persist(Signup2);
        System.out.println("HEJ");
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

        Role userRole = new Role("user");
        Role adminRole = new Role("admin");
        user.addRole(userRole);
        admin.addRole(adminRole);
        both.addRole(userRole);
        both.addRole(adminRole);
        em.persist(userRole);
        em.persist(adminRole);
        em.persist(user);
        em.persist(admin);
        em.persist(both);
        em.getTransaction().commit();
        System.out.println("PW: " + user.getUserPass());
        System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
        System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
        System.out.println("Created TEST Users");

    }

}
