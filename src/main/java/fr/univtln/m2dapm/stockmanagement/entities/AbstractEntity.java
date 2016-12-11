package fr.univtln.m2dapm.stockmanagement.entities;

import fr.univtln.m2dapm.stockmanagement.interfaces.IAbstractEntity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Maxime Gajovski on 11/12/2016.
 */
@MappedSuperclass
public abstract class AbstractEntity<K extends Serializable> implements IAbstractEntity<K>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;
        AbstractEntity<?> that = (AbstractEntity<?>) o;
        return getId() != null && getId().equals(that.getId());
//        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "" +  id;
    }
}