package fr.univtln.m2dapm.stockmanagement.entities.classes.equipments;

import fr.univtln.m2dapm.stockmanagement.entities.interfaces.equipments.ISlideProjector;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */
@Entity
@DiscriminatorValue("SLIDE_ROJECTOR")
public class SlideProjector extends AbstractEquipment implements ISlideProjector {

    protected SlideProjector (){

    }

    private SlideProjector(SlideProjector.Builder slideProjectorBuilder){
        this.information = slideProjectorBuilder.informationBuilder;
    }

    /* - - - - - - - - - - B U I L D E R - - - - - - - - - - */

    public static class Builder extends AbstractEquipment.Builder<ISlideProjector,SlideProjector.Builder> {

        @Override
        protected SlideProjector.Builder thisObject() {
            return this;
        }

        public ISlideProjector build() {
            return new SlideProjector(this);
        }

    }
}
