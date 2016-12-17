package fr.univtln.m2dapm.stockmanagement.interfaces;

import fr.univtln.m2dapm.stockmanagement.interfaces.embedabbles.IInformation;
import fr.univtln.m2dapm.stockmanagement.interfaces.embedabbles.IInformationRead;

/**
 * Created by Maxime Gajovski on 11/12/2016.
 */
public interface ILocal{

    public IInformationRead getInformation();
}
