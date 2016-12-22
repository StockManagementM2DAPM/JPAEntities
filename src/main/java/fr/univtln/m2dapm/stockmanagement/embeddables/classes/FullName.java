package fr.univtln.m2dapm.stockmanagement.embeddables.classes;

import fr.univtln.m2dapm.stockmanagement.annotations.teachers.ValidFirstName;
import fr.univtln.m2dapm.stockmanagement.annotations.teachers.ValidLastName;
import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IFullName;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */

@Embeddable
public class FullName implements IFullName {

    @ValidFirstName
    @Column(name = "FIRST_NAME")
    private String firstName;

    @ValidLastName
    @Column(name = "LAST_NAME")
    private String lastName;


    /* - - - - - - - - - - C O N S T R U C T O R S - - - - - - - - - - */

    /**
     * Empty constructor
     */
    public FullName(){
    }


    /* - - - - - - - - - - G E T T E R S - S E T T E R S  - - - - - - - - - - */

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public IFullName setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Override
    public IFullName setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    /* - - - - - - - - - - T O - S T R I N G - - - - - - - - - - */

    @Override
    public String toString() {
        return  "firstName : " + getFirstName() + "\n" +
                "lastName : " + getLastName()   + "\n";
    }
}
