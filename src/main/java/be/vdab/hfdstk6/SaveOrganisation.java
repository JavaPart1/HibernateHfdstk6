package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.Magazine;
import be.vdab.hfdstk6.domain.Member;
import be.vdab.hfdstk6.domain.Organisation;
import be.vdab.hfdstk6.domain.Reader;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

public class SaveOrganisation {
    public static void main(String[] args) {
        String pgmName = SaveOrganisation.class.getSimpleName();
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            // Domain creations
            Set<Member> memberSet = new HashSet<>();
            Set<Organisation> organisationSet = new HashSet<>();
            Member hln = new Member("HLN");
            Member stan = new Member("De Standaard");
            Member tijd = new Member("De Tijd");
            memberSet.add(hln);
            memberSet.add(stan);
            memberSet.add(tijd);
            Organisation organisation = new Organisation("Night Reader");
            organisation.setMembers(memberSet);
            organisationSet.add(organisation);
            hln.setOrganisations(organisationSet);
            stan.setOrganisations(organisationSet);
            tijd.setOrganisations(organisationSet);
            System.out.println(pgmName + " - Start txn");
            tx.begin();
            em.persist(organisation);
            em.persist(hln);
            em.persist(stan);
            em.persist(tijd);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(pgmName + " - Reader created");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
