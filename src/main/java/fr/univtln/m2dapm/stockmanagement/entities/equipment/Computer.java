package fr.univtln.m2dapm.stockmanagement.entities.equipment;

import fr.univtln.m2dapm.stockmanagement.interfaces.equipment.IComputer;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */

@Entity
@DiscriminatorValue("COMPUTER")
public class Computer extends AbstractEquipment implements IComputer {
}
