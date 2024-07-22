package br.edu.unifei.ecot13.projetofinal;

import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App {

    public static void main(String[] args) {

        // Creating objects in Java
        PureLamb pureLamb = new PureLamb();
        pureLamb.setName("Pure Lamb");
        pureLamb.setAge(1);
        pureLamb.setWeight(15);
        pureLamb.setColor("White");
        pureLamb.setHasHorn(false);
        pureLamb.setLineage("Lineage XYZ");
        pureLamb.setFirstBorn(true);
        pureLamb.setDaysAwaysFromMother(30);

        ImpureLamb impureLamb = new ImpureLamb();
        impureLamb.setName("Impure Lamb");
        impureLamb.setAge(3);
        impureLamb.setWeight(25);
        impureLamb.setColor("Black");
        impureLamb.setHasHorn(true);
        impureLamb.setImpurityDetail("Impurity details");
        impureLamb.setDiseased(true);

        CrossbredLamb crossbredLamb = new CrossbredLamb();
        crossbredLamb.setName("Crossbred Lamb");
        crossbredLamb.setAge(2);
        crossbredLamb.setWeight(18);
        crossbredLamb.setColor("Brown");
        crossbredLamb.setHasHorn(false);
        crossbredLamb.setFatherBreed("Breed A");
        crossbredLamb.setMotherBreed("Breed B");

        FlatFarm flatFarm = new FlatFarm();
        flatFarm.setName("Flat Farm");
        flatFarm.setLocation("Flatland");
        flatFarm.setMaxCapacity(100);
        flatFarm.setAreaOfValley(150.5f);
        flatFarm.setTypeOfSolo("Sandy");
        flatFarm.setNumberOfLakes(2);

        MountainFarm mountainFarm = new MountainFarm();
        mountainFarm.setName("Mountain Farm");
        mountainFarm.setLocation("Mountainous Region");
        mountainFarm.setMaxCapacity(50);
        mountainFarm.setMaxHeight(1000);
        mountainFarm.setInclinationDegrees(20.5f);

        Flock flock = new Flock();
        flock.setName("Flock 1");
        flock.setNumberOfLambs(30);
        flock.getLambs().add(pureLamb);
        flock.getLambs().add(impureLamb);
        flock.getLambs().add(crossbredLamb);
        pureLamb.setFlock(flock);
        impureLamb.setFlock(flock);
        crossbredLamb.setFlock(flock);

        Shepherd shepherd = new Shepherd();
        shepherd.setName("John Doe");
        shepherd.setAge(40);
        shepherd.setDocile(true);
        shepherd.getFlocks().add(flock);
        flock.setShepherd(shepherd);

        Temple temple = new Temple();
        temple.setArea(500.0f);
        temple.setHollyOfHollies(1);
        temple.setLocation("Jerusalem");
        temple.setCapacity(500);

        Priest priest = Priest.getInstancia();

        temple.setPriest(priest);

        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("trabalhofinal", properties);
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.persist(flatFarm);
        em.persist(mountainFarm);
        em.persist(shepherd);
        em.persist(temple);
        em.merge(pureLamb);
        em.persist(impureLamb);
        em.persist(crossbredLamb);
        em.persist(flock);
        
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
