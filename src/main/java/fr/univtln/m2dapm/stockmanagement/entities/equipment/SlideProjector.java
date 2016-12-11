package fr.univtln.m2dapm.stockmanagement.entities.equipment;

import fr.univtln.m2dapm.stockmanagement.interfaces.equipment.ISlideProjector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */
@Entity
@DiscriminatorValue("SLIDE_ROJECTOR")
public class SlideProjector extends AbstractEquipment implements ISlideProjector {
}
