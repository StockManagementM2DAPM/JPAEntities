package fr.univtln.m2dapm.stockmanagement.entities;

import fr.univtln.m2dapm.stockmanagement.entities.embeddables.FullName;
import fr.univtln.m2dapm.stockmanagement.entities.embeddables.Information;
import fr.univtln.m2dapm.stockmanagement.entities.equipment.AbstractEquipment;
import fr.univtln.m2dapm.stockmanagement.interfaces.IClassRoom;
import fr.univtln.m2dapm.stockmanagement.interfaces.ITeacher;
import fr.univtln.m2dapm.stockmanagement.interfaces.embedabbles.IInformation;
import fr.univtln.m2dapm.stockmanagement.interfaces.equipment.IEquipment;
import fr.univtln.m2dapm.stockmanagement.interfaces.ISchool;

import org.hibernate.annotations.Target;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */

@Entity
@Table(name = "SCHOOL")
public class School extends AbstractEntity<Long> implements ISchool {

    @Embedded
    @Target(value = Information.class)
    private IInformation information;


    @OneToMany(
            cascade = CascadeType.ALL,
            targetEntity = ClassRoom.class)
    private Collection<IClassRoom> classRooms;

    @OneToMany(
            cascade = CascadeType.ALL,
            targetEntity = AbstractEquipment.class)
    private Collection<IEquipment> equipments;

    @OneToMany(
            cascade = CascadeType.ALL,
            targetEntity = Teacher.class)
//    @JoinColumn(table = "SCHOOL", name = "TEACHER_ID")
//    @JoinColumn(name="ID")
    private Collection<ITeacher> teachers;


    public School(){
        information = new Information();
        equipments  = new HashSet<>();
        classRooms  = new HashSet<>();
        teachers    = new HashSet<>();
    }


    @Override
    public Collection<IClassRoom> getClassRooms() {
        return classRooms;
    }

    @Override
    public Collection<IEquipment> getEquipments() {
        return equipments;
    }

    @Override
    public Collection<ITeacher> getTeachers() {
        return teachers;
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
        information.setDescription(description);
        return information;
    }

    @Override
    public String toString() {
        return super.toString() + information.getName();
    }
}
