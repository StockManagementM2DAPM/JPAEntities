package fr.univtln.m2dapm.stockmanagement.interfaces.embedabbles;

/**
 * Created by Maxime Gajovski on 17/12/2016.
 */
public interface IInformationWrite<K> {

    K   setName(String name);
    K   setDescription(String description);
}
