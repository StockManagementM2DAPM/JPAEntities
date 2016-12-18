package fr.univtln.m2dapm.stockmanagement.entity.classes.actors;

import fr.univtln.m2dapm.stockmanagement.embeddable.classes.FullName;
import fr.univtln.m2dapm.stockmanagement.embeddable.interfaces.IFullName;
import fr.univtln.m2dapm.stockmanagement.entity.classes.AbstractEntity;
import fr.univtln.m2dapm.stockmanagement.entity.interfaces.actors.ITeacher;
import fr.univtln.m2dapm.stockmanagement.embeddable.interfaces.IFullNameWrite;
import org.hibernate.annotations.Target;

import javax.persistence.*;

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
    public String getFirstName() {
        return fullName.getFirstName();
    }

    @Override
    public String getLastName() {
        return fullName.getLastName();
    }

    @Override
    public IFullName setFirstName(String firstName) {
        fullName.setFirstName(firstName);
        return fullName;
    }

    @Override
    public IFullName setLastName(String lastName) {
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
        public Builder setFirstName(String firstName) {
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
