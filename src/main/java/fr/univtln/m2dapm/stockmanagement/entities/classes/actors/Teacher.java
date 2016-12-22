package fr.univtln.m2dapm.stockmanagement.entities.classes.actors;

import fr.univtln.m2dapm.stockmanagement.embeddables.classes.FullName;
import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IFullName;
import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IFullNameWrite;
import fr.univtln.m2dapm.stockmanagement.entities.classes.AbstractEntity;
import fr.univtln.m2dapm.stockmanagement.entities.interfaces.actors.ITeacher;
import org.hibernate.annotations.Target;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;


/**
 * Created by Maxime Gajovski on 07/12/2016.
 */
@Entity
@Table(name ="TEACHER")
public class Teacher extends AbstractEntity<Long> implements ITeacher{

    @Embedded
    @Target(FullName.class)
    private IFullName fullName;

    /* - - - - - - - - - - C O N S T R U C T O R S - - - - - - - - - - */

    protected Teacher(){
    }

    private Teacher(Teacher.Builder teacherBuilder){
        this.fullName = teacherBuilder.fullNameBuilder;
    }

    /* - - - - - - - - - - G E T T E R S - S E T T E R S  - - - - - - - - - - */

    @Override
    public IFullName getFullName() {
        return fullName;
    }

    @Override
    public String getFirstName() {
        return fullName.getFirstName();
    }

    @Override
    public String getLastName() {
        return fullName.getLastName();
    }

    @Override
    public IFullName setFirstName(  String firstName) {
       fullName.setFirstName(firstName);
        return fullName;
    }

    @Override
    public IFullName setLastName( String lastName) {
        fullName.setFirstName(lastName);
        return fullName;
    }


    /* - - - - - - - - - - T O - S T R I N G - - - - - - - - - - */

    @Override
    public String toString() {
        return  super.toString()        + "\n" +
                fullName.toString()     + "\n";
    }


    /* - - - - - - - - - - B U I L D E R - - - - - - - - - - */

    public static class Builder implements IFullNameWrite<Builder> {

        private IFullName fullNameBuilder;

        public Builder(){
            fullNameBuilder = new FullName();
        }

        @Override
        public Builder setFirstName( String firstName) {
            fullNameBuilder.setFirstName(firstName);
            return this;
        }

        @Override
        public Builder setLastName(String lastName) {
            fullNameBuilder.setLastName(lastName);
            return this;
        }

        public ITeacher build(){
            return new Teacher(this);
        }
    }

}
