package fr.univtln.m2dapm.stockmanagement.entities;

import fr.univtln.m2dapm.stockmanagement.entities.embeddables.FullName;
import fr.univtln.m2dapm.stockmanagement.interfaces.embedabbles.IFullName;
import fr.univtln.m2dapm.stockmanagement.interfaces.ITeacher;
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

    public Teacher(){
        fullName = new FullName();
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
    public IFullName setFirstName(String firstName) {
        fullName.setFirstName(firstName);
        return fullName;
    }

    @Override
    public IFullName setLastName(String lastName) {
        fullName.setFirstName(lastName);
        return fullName;
    }
}
