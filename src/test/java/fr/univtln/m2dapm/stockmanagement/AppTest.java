package fr.univtln.m2dapm.stockmanagement;

import fr.univtln.m2dapm.stockmanagement.entities.ClassRoom;
import fr.univtln.m2dapm.stockmanagement.entities.School;
import fr.univtln.m2dapm.stockmanagement.entities.Teacher;
import fr.univtln.m2dapm.stockmanagement.entities.equipment.BoardMarker;
import fr.univtln.m2dapm.stockmanagement.entities.equipment.ChalkBox;
import fr.univtln.m2dapm.stockmanagement.entities.equipment.Computer;
import fr.univtln.m2dapm.stockmanagement.interfaces.IClassRoom;
import fr.univtln.m2dapm.stockmanagement.interfaces.ISchool;
import fr.univtln.m2dapm.stockmanagement.interfaces.ITeacher;
import fr.univtln.m2dapm.stockmanagement.interfaces.equipment.IEquipment;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {


        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("hibernate-h2-stock");
        EntityManager em = emf.createEntityManager();



        EntityTransaction transac = em.getTransaction();


        IEquipment computer = new Computer();
        IEquipment chalkBox = new ChalkBox();
        IEquipment boardMarker = new BoardMarker();


        computer.setName("Computer");
        chalkBox.setName("ChalkBox");
        boardMarker.setName("BoardMarker");


        IClassRoom classRoom = new ClassRoom();
        classRoom.setName("U026");

        ITeacher teacher = new Teacher();
        teacher.setFirstName("Bruno")
                .setLastName("Emannuel");

        ISchool school = new School();
        school.setName("Fac de la Garde");

        school.getClassRooms().add(classRoom);
        school.getEquipments().add(computer);
        school.getEquipments().add(chalkBox);
        school.getEquipments().add(boardMarker);
        school.getTeachers().add(teacher);


        transac.begin();
        em.persist(classRoom);
        em.persist(school);
        transac.commit();

    }
}
