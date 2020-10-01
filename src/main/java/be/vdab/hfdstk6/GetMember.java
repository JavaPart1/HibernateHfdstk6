package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Member;
import be.vdab.hfdstk6.domain.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GetMember {
    public static void main(String[] args) {
        String pgmName = GetMember.class.getSimpleName();
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx =em.getTransaction();
            System.out.println(pgmName + " - Start txn");
            tx.begin();
            Member hln = em.find(Member.class, 2L);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(hln.toString());
            System.out.println("Organisations: ");
            hln.getOrganisations().stream().forEach(organisation -> System.out.println(organisation.getOrganisationName()));
            System.out.println(pgmName + " - End of program");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
