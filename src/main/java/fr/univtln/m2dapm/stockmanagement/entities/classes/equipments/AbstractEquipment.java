package fr.univtln.m2dapm.stockmanagement.entities.classes.equipments;

import fr.univtln.m2dapm.stockmanagement.embeddables.classes.Information;
import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IInformation;
import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IInformationWrite;
import fr.univtln.m2dapm.stockmanagement.entities.classes.AbstractEntity;
import fr.univtln.m2dapm.stockmanagement.entities.interfaces.equipments.IEquipment;
import org.hibernate.annotations.Target;

import javax.persistence.*;
import javax.validation.Valid;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
@Table(name = "EQUIPMENT")
public abstract class AbstractEquipment  extends AbstractEntity<Long> implements IEquipment {

    @Valid
    @fr.univtln.m2dapm.stockmanagement.beanvalidation.annotations.Information
    @Embedded
    @Target(Information.class)
    protected IInformation information;

    protected AbstractEquipment()
    {
        information = new Information();
    }


    /* - - - - - - - - - - G E T T E R S - S E T T E R S  - - - - - - - - - - */

    @Override
    public IInformation getInformation(){
        return information;
    }

    @Override
    public String getName(){
        return information.getName();
    }

    @Override
    public IInformation setName(String name){
        information.setName(name);
        return information;
    }

    @Override
    public String getDescription(){
        return information.getDescription();
    }

    @Override
    public IInformation setDescription(String description){
        information.setDescription(description);
        return information;
    }



    /* - - - - - - - - - - T O - S T R I N G - - - - - - - - - - */


    /* - - - - - - - - - - B U I L D E R - - - - - - - - - - */

    abstract static class Builder<K extends IEquipment, T extends Builder<K, T>> implements IInformationWrite<Builder> {

        protected IInformation informationBuilder;

        protected Builder()
        {
            this.informationBuilder = new Information();
        }

        @Override
        public T setName(String name)
        {
            informationBuilder.setName(name);
            return thisObject();
        }

        @Override
        public T setDescription(String description) {
            informationBuilder.setDescription(description);
            return thisObject();
        }

    /* ---------- O T H E R - M E T H O D S ---------- */


        protected abstract T thisObject();
        protected abstract K build();
    }
}
