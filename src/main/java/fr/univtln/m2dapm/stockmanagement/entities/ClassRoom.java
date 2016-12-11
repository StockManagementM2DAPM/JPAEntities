package fr.univtln.m2dapm.stockmanagement.entities;

import fr.univtln.m2dapm.stockmanagement.entities.embeddables.Information;
import fr.univtln.m2dapm.stockmanagement.interfaces.IClassRoom;
import fr.univtln.m2dapm.stockmanagement.interfaces.ISchool;
import fr.univtln.m2dapm.stockmanagement.interfaces.embedabbles.IInformation;
import org.hibernate.annotations.Target;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Maxime Gajovski on 11/12/2016.
 */

@Entity
@Table(name = "CLASSROOM")
public class ClassRoom extends AbstractEntity<Long> implements IClassRoom {


    @Embedded
    @Target(Information.class)
    private IInformation information;

    public ClassRoom(){
        information = new Information();
    }

    @Override
    public String getName() {
        return information.getName();
    }

    @Override
    public IInformation setName(String name) {
        information.setName(name);
        return information;
    }

    @Override
    public String getDescription() {
        return information.getDescription();
    }

    @Override
    public IInformation setDescription(String description) {
        information.setName(description);
        return information;
    }
}
