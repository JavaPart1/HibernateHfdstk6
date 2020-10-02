package be.vdab.hfdstk6;

import be.vdab.hfdstk6.domain.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SaveGraduate {
    public static void main(String[] args) {
        String pgmName = SaveGraduate.class.getSimpleName();
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("mysqlcontainer");
            em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();
            // Domain creations
            List<GraduateDegree> gradDegList1 = new ArrayList<>();
            List<GraduateDegree> gradDegList2 = new ArrayList<>();
            List<GraduateDegree> gradDegList3 = new ArrayList<>();
            List<GraduateDegree> gradDegList4 = new ArrayList<>();
            List<GraduateDegree> gradDegList5 = new ArrayList<>();
            List<GraduateDegree> gradDegList6 = new ArrayList<>();
            List<GraduateDegree> gradDegList7 = new ArrayList<>();
            List<GraduateDegree> gradDegList8 = new ArrayList<>();
            List<GraduateDegree> gradDegList9 = new ArrayList<>();
            // Graduates
            Graduate bert = new Graduate("Bert");
            Graduate gert = new Graduate("Gert");
            Graduate mert = new Graduate("Mert");
            // Degrees
            Degree master = new Degree("Master");
            Degree bach = new Degree("Bachelor");
            Degree prof = new Degree("Prof");
            // GraduateDegrees and links
            GraduateDegree bertbach = new GraduateDegree(9,bert,bach);
            GraduateDegree bertmaster = new GraduateDegree(6,bert,master);
            GraduateDegree gertbach = new GraduateDegree(8,gert,bach);
            GraduateDegree gertmaster = new GraduateDegree(6,gert,master);
            GraduateDegree mertbach = new GraduateDegree(10,mert,bach);
            GraduateDegree mertmaster = new GraduateDegree(9,mert,master);
            GraduateDegree mertprof = new GraduateDegree(8,mert,prof);
            // Graduates links
            gradDegList1.add(gertbach);
            gradDegList1.add(gertmaster);
            gert.setDegrees(gradDegList1);
//            gradDegList.clear();
            gradDegList2.add(bertbach);
            gradDegList2.add(bertmaster);
            bert.setDegrees(gradDegList2);
//            gradDegList.clear();
            gradDegList3.add(mertbach);
            gradDegList3.add(mertmaster);
            gradDegList3.add(mertprof);
            mert.setDegrees(gradDegList3);
//            gradDegList.clear();
            // Degree links
            gradDegList4.add(bertmaster);
            gradDegList4.add(gertmaster);
            gradDegList4.add(mertmaster);
            master.setGraduates(gradDegList4);
//            gradDegList.clear();
            gradDegList5.add(bertbach);
            gradDegList5.add(gertbach);
            gradDegList5.add(mertbach);
            bach.setGraduates(gradDegList5);
//            gradDegList.clear();
            gradDegList6.add(mertprof);
            prof.setGraduates(gradDegList6);
            System.out.println(bert.toString());
            System.out.println(gert.toString());
            System.out.println(mert.toString());
            System.out.println(pgmName + " - Start txn");
            tx.begin();
            em.persist(bert);
            em.persist(gert);
            em.persist(mert);
//            em.persist(prof);
//            em.persist(master);
//            em.persist(bach);
//            em.persist(bertbach);
//            em.persist(bertmaster);
//            em.persist(gertbach);
//            em.persist(gertmaster);
//            em.persist(mertbach);
//            em.persist(mertmaster);
//            em.persist(mertprof);
            tx.commit();
            System.out.println(pgmName + " - Commit txn");
            System.out.println(pgmName + " - Save executed");
        } finally {
            if (em != null) em.close();
            if (emf != null) emf.close();
        }

    }
}
