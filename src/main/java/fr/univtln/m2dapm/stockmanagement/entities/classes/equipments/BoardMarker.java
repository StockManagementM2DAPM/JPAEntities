package fr.univtln.m2dapm.stockmanagement.entities.classes.equipments;

import fr.univtln.m2dapm.stockmanagement.entities.interfaces.equipments.IBoardMarker;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */
@Entity
@DiscriminatorValue("BOARD_MARKER")
public class BoardMarker extends AbstractEquipment implements IBoardMarker {


    protected BoardMarker(){

    }

    private BoardMarker(BoardMarker.Builder boardMarkerBuilder){
        this.information = boardMarkerBuilder.informationBuilder;
    }

    /* - - - - - - - - - - B U I L D E R - - - - - - - - - - */

    public static class Builder extends AbstractEquipment.Builder<IBoardMarker, BoardMarker.Builder> {

        @Override
        protected Builder thisObject() {
            return this;
        }

        public IBoardMarker build() {
            return new BoardMarker(this);
        }

    }

}
