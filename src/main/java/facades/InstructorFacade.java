/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.InstructorDTO;
import entities.Instructor;
import errorhandling.NotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class InstructorFacade {

    private static EntityManagerFactory emf;
    private static InstructorFacade instance;

    public InstructorFacade() {
    }

    public static InstructorFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new InstructorFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public InstructorDTO addInstructor(InstructorDTO IDTO) {
        EntityManager em = emf.createEntityManager();
        Instructor instruc = new Instructor(IDTO.getName());
        try {
            em.getTransaction().begin();
            em.persist(instruc);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return IDTO;
    }

    public InstructorDTO editInstructor(String instructor, int value) throws NotFoundException {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Instructor I = em.find(Instructor.class, (long) value);
            if (I == null) {
                throw new NotFoundException("No Instructor found");
            }
            I.setName(instructor);
            em.getTransaction().commit();
            return new InstructorDTO(I);
        } finally {
            em.close();
        }

    }

    public InstructorDTO deleteInstructor(Long id) throws NotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Instructor p = em.find(Instructor.class, id);
            System.out.println(p.getName());
            em.remove(p);
            em.getTransaction().commit();
            return new InstructorDTO(p);
        } catch (Exception e) {
            throw new NotFoundException("Could not delete, provided id does not exist");
        } finally {
            em.close();
        }

    }

}
