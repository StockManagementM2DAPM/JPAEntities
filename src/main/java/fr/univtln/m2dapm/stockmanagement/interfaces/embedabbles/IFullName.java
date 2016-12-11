package fr.univtln.m2dapm.stockmanagement.interfaces.embedabbles;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */

public interface IFullName {

    String      getFirstName();
    String      getLastName();
    IFullName   setFirstName(String firstName);
    IFullName   setLastName(String lastName);

}
