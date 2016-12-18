package fr.univtln.m2dapm.stockmanagement.entities.classes.equipments;

import fr.univtln.m2dapm.stockmanagement.entities.interfaces.equipments.IChalkBox;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */
@Entity
@DiscriminatorValue("CHALK_BOX")
public class ChalkBox  extends AbstractEquipment implements IChalkBox {

    protected ChalkBox(){

    }

    private ChalkBox(ChalkBox.Builder chalkBoxBuilder){
        this.information = chalkBoxBuilder.informationBuilder;
    }

    /* - - - - - - - - - - B U I L D E R - - - - - - - - - - */

    public static class Builder extends AbstractEquipment.Builder<IChalkBox, ChalkBox.Builder> {

        @Override
        protected ChalkBox.Builder thisObject() {
            return this;
        }

        public IChalkBox build() {
            return new ChalkBox(this);
        }

    }

}
