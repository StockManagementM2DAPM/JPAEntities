package fr.univtln.m2dapm.stockmanagement;

import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IFullName;
import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IInformation;
import fr.univtln.m2dapm.stockmanagement.entities.classes.actors.Teacher;
import fr.univtln.m2dapm.stockmanagement.entities.classes.equipments.BoardMarker;
import fr.univtln.m2dapm.stockmanagement.entities.classes.equipments.Computer;
import fr.univtln.m2dapm.stockmanagement.entities.classes.equipments.SlideProjector;
import fr.univtln.m2dapm.stockmanagement.entities.interfaces.actors.ITeacher;
import fr.univtln.m2dapm.stockmanagement.entities.interfaces.equipments.IEquipment;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Locale;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by toms on 12/20/16.
 */
public class ValidationTest {

    private static Validator validator;
    Locale frLocale = new Locale("fr","FR");

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    /**
     * Tests if ITeacher instance 's firstname and lastname are consistent
     */
    @Test
    public void testGoodTeacherName() {
        ITeacher iTeacher = new Teacher.Builder().setFirstName("Manu").setLastName("Petit").build();
        Set<ConstraintViolation<ITeacher>> constraintViolations =
                validator.validate( iTeacher);
        assertEquals( 0, constraintViolations.size() );
    }


    /**
     * Tests if @interface ValidFirstName and ValidLastName returns error messages
     */
    @Test
    public void testWrongTeacherName() {
        ITeacher iTeacher = new Teacher.Builder().setFirstName("X").setLastName("P").build();
        Set<ConstraintViolation<ITeacher>> constraintViolations =
                validator.validate( iTeacher);
        assertEquals( 1, constraintViolations.size() );
    }


    /**
     * Tests if IEquipment instance 's name and description are in good format
     */
    @Test
    public void testGoodObjectBuild(){
        IEquipment computer = new Computer.Builder()
                .setName("My computer")
                .setDescription("This one is awsome")
                .build();

        Set<ConstraintViolation<IEquipment>> constraintViolations =
                validator.validate( computer);
        assertEquals( 0, constraintViolations.size() );
    }


    /**
     * Tests if iEquipment instance description.length() is right or not
     */
    @Test
    public void testWrongObjectDescriptor(){
        IEquipment b = new BoardMarker.Builder()
                .setName("My computer")
                .setDescription("NO")
                .build();

        System.out.println(b.getName().length());

        Set<ConstraintViolation<IEquipment>> constraintViolations =
                validator.validate( b);
        assertEquals( 1, constraintViolations.size() );
    }


    /**
     * Tests if iEquipment instance name.length() is right or not
     */
    @Test
    public void testWrongObjectName(){
        IEquipment slide = new SlideProjector.Builder()
                .setName("SB")
                .setDescription("I am just a slideBoard")
                .build();

        Set<ConstraintViolation<IEquipment>> constraintViolations =
                validator.validate( slide);
        assertEquals( 1, constraintViolations.size() );
    }

}
