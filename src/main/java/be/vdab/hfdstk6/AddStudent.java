package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.School;
import be.vdab.hfdstk6.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AddStudent {
    public static void main(String[] args) {
        String pgmName = "AddStudent";
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            // Get School
            System.out.println(pgmName + " - Start txn Get School");
            tx.begin();
            School school = em.find(School.class, 3L);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            // Domain creations
            Student viv = new Student("Vivaldi");
            viv.setSchool(school);
            school.getStudents().add(viv);
            System.out.println(pgmName + " - Start txn Save School");
            tx.begin();
            em.persist(viv);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(pgmName + " - Student added");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
