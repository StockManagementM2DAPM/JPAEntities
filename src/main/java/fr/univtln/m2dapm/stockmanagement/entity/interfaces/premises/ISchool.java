package fr.univtln.m2dapm.stockmanagement.entity.interfaces.premises;

import fr.univtln.m2dapm.stockmanagement.entity.interfaces.IAbstractEntity;
import fr.univtln.m2dapm.stockmanagement.entity.interfaces.actors.ITeacher;
import fr.univtln.m2dapm.stockmanagement.entity.interfaces.equipments.IEquipment;

import java.util.Collection;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */
public interface ISchool extends IAbstractEntity<Long>, ILocal{

    Collection<IClassRoom>  getClassRooms();
    Collection<IEquipment>  getEquipments();
    Collection<ITeacher>    getTeachers();
}
