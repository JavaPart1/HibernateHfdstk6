package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.MedicalFile;
import be.vdab.hfdstk6.domain.Patient;
import be.vdab.hfdstk6.domain.School;
import be.vdab.hfdstk6.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class SaveSchool {
    public static void main(String[] args) {
        String pgmName = "SaveSchool  ";
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            // Domain creations
            List<Student> studs = new ArrayList<>();
            School dolmen = new School("Dolmen");
            Student bert = new Student("Bert");
            Student bart = new Student("Bart");
            Student dirk = new Student("Dirk");
            Student marleen = new Student("Marleen");
            studs.add(bart);
            studs.add(bert);
            studs.add(dirk);
            studs.add(marleen);
            dolmen.setStudents(studs);
            bart.setSchool(dolmen);
            bert.setSchool(dolmen);
            dirk.setSchool(dolmen);
            marleen.setSchool(dolmen);
            System.out.println(pgmName + " - Start txn");
            tx.begin();
            em.persist(dolmen);
            em.persist(bart);
            em.persist(bert);
            em.persist(dirk);
            em.persist(marleen);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(pgmName + " - School created");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
