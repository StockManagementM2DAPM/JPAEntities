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


    protected Computer(){

    }

    private Computer(Computer.Builder computerBuilder){
        this.information = computerBuilder.informationBuilder;
    }

    /* - - - - - - - - - - B U I L D E R - - - - - - - - - - */

    public static class Builder extends AbstractEquipment.Builder<IComputer, Computer.Builder> {

        @Override
        protected Computer.Builder thisObject() {
            return this;
        }

        public IComputer build() {
            return new Computer(this);
        }

    }

}
