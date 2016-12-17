package fr.univtln.m2dapm.stockmanagement.entities;

import fr.univtln.m2dapm.stockmanagement.entities.embeddables.Information;
import fr.univtln.m2dapm.stockmanagement.entities.equipment.AbstractEquipment;
import fr.univtln.m2dapm.stockmanagement.interfaces.IClassRoom;
import fr.univtln.m2dapm.stockmanagement.interfaces.ITeacher;
import fr.univtln.m2dapm.stockmanagement.interfaces.embedabbles.IInformation;
import fr.univtln.m2dapm.stockmanagement.interfaces.embedabbles.IInformationWrite;
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
    private Collection<ITeacher> teachers;



    /* - - - - - - - - - - C O N S T R U C T O R S - - - - - - - - - - */

    protected School(){
    }

    private School(School.Builder schoolBuilder){
        this.information = schoolBuilder.informationBuilder;
        this.equipments  = schoolBuilder.equipmentsBuilder;
        this.classRooms  = schoolBuilder.classRoomsBuilder;
        this.teachers    = schoolBuilder.teachersBuilder;
    }


    /* - - - - - - - - - - G E T T E R S - S E T T E R S  - - - - - - - - - - */

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
    public IInformation getInformation() {
        return information;
    }

    /* - - - - - - - - - - T O - S T R I N G - - - - - - - - - - */

    @Override
    public String toString() {
        return super.toString() + information.getName();
    }


    /* - - - - - - - - - - B U I L D E R - - - - - - - - - - */


    public static class Builder implements IInformationWrite<Builder>
    {

        private IInformation            informationBuilder;
        private Collection<IClassRoom>  classRoomsBuilder;
        private Collection<IEquipment>  equipmentsBuilder;
        private Collection<ITeacher>    teachersBuilder;

        public Builder(){
            informationBuilder = new Information();
            equipmentsBuilder  = new HashSet<>();
            classRoomsBuilder  = new HashSet<>();
            teachersBuilder    = new HashSet<>();
        }

        @Override
        public Builder setName(String name) {
            informationBuilder.setName(name);
            return this;
        }

        @Override
        public Builder setDescription(String description) {
            informationBuilder.setDescription(description);
            return this;
        }

        public Builder addTeacher(ITeacher teacher){
            teachersBuilder.add(teacher);
            return this;
        }

        public Builder addTeachers(ITeacher ... teachers){
            for(ITeacher teacher : teachers)
                addTeacher(teacher);
            return this;
        }

        public Builder addEquipment(IEquipment equipment){
            equipmentsBuilder.add(equipment);
            return this;
        }

        public Builder addEquipments(IEquipment... equipments){
            for(IEquipment equipment: equipments)
                addEquipment(equipment);
            return this;
        }

        public Builder addClassRoom(IClassRoom classRoom){
            classRoomsBuilder.add(classRoom);
            return this;
        }

        public Builder addClassRooms(IClassRoom ... classRooms){
            for(IClassRoom classRoom: classRooms)
                addClassRoom(classRoom);
            return this;
        }

        public ISchool build(){
            return new School(this);
        }
    }
}
