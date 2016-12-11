package fr.univtln.m2dapm.stockmanagement.entities.equipment;

import fr.univtln.m2dapm.stockmanagement.entities.AbstractEntity;
import fr.univtln.m2dapm.stockmanagement.entities.embeddables.Information;
import fr.univtln.m2dapm.stockmanagement.interfaces.embedabbles.IInformation;
import fr.univtln.m2dapm.stockmanagement.interfaces.equipment.IEquipment;

import org.hibernate.annotations.Target;

import javax.persistence.*;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE")
@Table(name = "EQUIPMENT")
public abstract class AbstractEquipment  extends AbstractEntity<Long> implements IEquipment {

    @Embedded
    @Target(Information.class)
    private IInformation information;

    public AbstractEquipment(){
        information = new Information();
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
}
