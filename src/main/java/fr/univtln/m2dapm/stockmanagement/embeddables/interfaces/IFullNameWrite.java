package fr.univtln.m2dapm.stockmanagement.embeddables.interfaces;

import fr.univtln.m2dapm.stockmanagement.annotations.teachers.ValidFirstName;
import fr.univtln.m2dapm.stockmanagement.annotations.teachers.ValidLastName;

/**
 * Created by Maxime Gajovski on 17/12/2016.
 */
public interface IFullNameWrite<K>{

    K   setFirstName( @ValidFirstName String firstName);
    K   setLastName( @ValidLastName String lastName);
}
