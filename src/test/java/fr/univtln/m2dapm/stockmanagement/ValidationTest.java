package fr.univtln.m2dapm.stockmanagement;

import fr.univtln.m2dapm.stockmanagement.annotations.ValidName;
import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IFullName;
import fr.univtln.m2dapm.stockmanagement.entities.classes.actors.Teacher;
import fr.univtln.m2dapm.stockmanagement.entities.interfaces.actors.ITeacher;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.*;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * Created by toms on 12/20/16.
 */
public class ValidationTest {

    //TODO -> beaucoup trop de choses...

    private static Validator validator;
    //@ValidName -> sert à rien pour l'instant
    private IFullName iFullName;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void testGoodTeacherName() {
        ITeacher iTeacher = new Teacher.Builder().setFirstName("Manu").setLastName("Petit").build();
        iFullName = iTeacher.getFullName();
        Set<ConstraintViolation<IFullName>> constraintViolations =
                validator.validate( iFullName);
        assertEquals( 0, constraintViolations.size() );
    }


    @Test
    public void testWrongTeacherName() {
        ITeacher iTeacher = new Teacher.Builder().setFirstName("X").setLastName("Petit").build();
        IFullName iFullName;
        iFullName = iTeacher.getFullName();
        Set<ConstraintViolation<IFullName>> constraintViolations =
                validator.validate( iFullName);
        assertEquals( 1, constraintViolations.size() );
        assertEquals("La taille du prenom doit etre comprise entre 2 et 30 caracteres", constraintViolations.iterator().next().getMessage());

    }
}
