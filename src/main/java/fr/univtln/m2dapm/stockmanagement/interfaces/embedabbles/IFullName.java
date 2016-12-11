package fr.univtln.m2dapm.stockmanagement.interfaces;

import fr.univtln.m2dapm.stockmanagement.entities.FullName;
import org.hibernate.annotations.Target;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */

public interface IFullName {

    String      getFirstName();
    String      getLastName();
    IFullName   setFirstName(String firstName);
    IFullName   setLastName(String lastName);

}
