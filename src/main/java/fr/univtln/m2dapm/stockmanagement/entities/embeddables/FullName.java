package fr.univtln.m2dapm.stockmanagement.entities;

import fr.univtln.m2dapm.stockmanagement.interfaces.IFullName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */

@Embeddable
public class FullName implements IFullName {

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;


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
}
