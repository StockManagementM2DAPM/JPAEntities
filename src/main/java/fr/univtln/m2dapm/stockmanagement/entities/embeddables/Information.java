package fr.univtln.m2dapm.stockmanagement.entities.embeddables;

import fr.univtln.m2dapm.stockmanagement.interfaces.embedabbles.IInformation;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by Maxime Gajovski on 11/12/2016.
 */

@Embeddable
public class Information implements IInformation {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public Information(){

    }


    public String getName() {
        return name;
    }

    public IInformation setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public IInformation setDescription(String description) {
        this.description = description;
        return this;
    }
}
