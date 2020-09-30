package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SavePatient {
    public static void main(String[] args) {
        String pgmName = "SavePatient  ";
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            // Domain creations
            Patient bart = new Patient("Bart");
            MedicalFile medicalFile = new MedicalFile(134,36);
            bart.setMedicalFile(medicalFile);
            medicalFile.setPatient(bart);
            System.out.println(pgmName + " - Start txn");
            tx.begin();
            em.persist(bart);
            em.persist(medicalFile);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(pgmName + " - Customer created");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
