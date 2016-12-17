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


    protected BoardMarker(){

    }

    private BoardMarker(BoardMarker.Builder boardMarkerBuilder){
        System.out.println(boardMarkerBuilder.informationBuilder.getName());
        System.out.println(boardMarkerBuilder.informationBuilder.getDescription());
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
