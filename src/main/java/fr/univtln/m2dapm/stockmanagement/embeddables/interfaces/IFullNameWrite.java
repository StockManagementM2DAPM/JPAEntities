package fr.univtln.m2dapm.stockmanagement.embeddables.interfaces;

/**
 * Created by Maxime Gajovski on 17/12/2016.
 */
public interface IFullNameWrite<K>{

    K   setFirstName( String firstName);
    K   setLastName( String lastName);
}
