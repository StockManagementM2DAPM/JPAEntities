package fr.univtln.m2dapm.stockmanagement.entities.interfaces.equipments;

import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IInformation;
import fr.univtln.m2dapm.stockmanagement.entities.interfaces.IAbstractEntity;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */
public interface IEquipment extends IAbstractEntity<Long>, IInformation {
    IInformation getInformation();
}

