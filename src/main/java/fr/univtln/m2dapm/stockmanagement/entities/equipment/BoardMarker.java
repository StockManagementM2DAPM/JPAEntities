package fr.univtln.m2dapm.stockmanagement.entities.equipment;

import fr.univtln.m2dapm.stockmanagement.interfaces.equipment.IBoardMarker;
import fr.univtln.m2dapm.stockmanagement.interfaces.equipment.IChalkBox;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */
@Entity
@DiscriminatorValue("BOARD_MARKER")
public class BoardMarker extends AbstractEquipment implements IBoardMarker {

}
