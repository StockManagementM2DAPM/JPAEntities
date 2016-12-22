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
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by toms on 12/20/16.
 */
public class ValidationTest {

    //TODO -> beaucoup trop de choses...

    private static Validator validator;
    private IFullName iFullName;
    private IInformation iInformation;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    /**
     * Tests if ITeacher instance 's firstname and lastname are in good format
     */
    @Test
    public void testGoodTeacherName() {
        ITeacher iTeacher = new Teacher.Builder().setFirstName("Manu").setLastName("Petit").build();
        iFullName = iTeacher.getFullName();
        Set<ConstraintViolation<IFullName>> constraintViolations =
                validator.validate( iFullName);
        assertEquals( 0, constraintViolations.size() );
    }


    /**
     * Tests if @interface ValidFirstName and ValidLastName returns error messages
     */
    @Test
    public void testWrongTeacherName() {
        ITeacher iTeacher = new Teacher.Builder().setFirstName("X").setLastName("P").build();
        IFullName iFullName;
        iFullName = iTeacher.getFullName();
        Set<ConstraintViolation<IFullName>> constraintViolations =
                validator.validate( iFullName);
        assertEquals( 2, constraintViolations.size() );
        assertEquals("La taille du nom doit etre comprise entre 2 et 30 caracteres",
                constraintViolations.iterator().next().getMessage());
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

        iInformation = computer.getInformation();

        Set<ConstraintViolation<IInformation>> constraintViolations =
                validator.validate( iInformation);
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

        iInformation = b.getInformation();

        Set<ConstraintViolation<IInformation>> constraintViolations =
                validator.validate( iInformation);
        assertEquals( 1, constraintViolations.size() );
        assertEquals("La description de l'objet doit etre comprise entre 10 et 200 caracteres",
                constraintViolations.iterator().next().getMessage());
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

        iInformation = slide.getInformation();

        Set<ConstraintViolation<IInformation>> constraintViolations =
                validator.validate( iInformation);
        assertEquals( 1, constraintViolations.size() );
        assertEquals("Le nom de l'objet doit contenir entre 10 et 200 caracteres",
                constraintViolations.iterator().next().getMessage());
    }

}
