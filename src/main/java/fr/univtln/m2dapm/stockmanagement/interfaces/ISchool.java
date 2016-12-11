package fr.univtln.m2dapm.stockmanagement.interfaces;

import fr.univtln.m2dapm.stockmanagement.interfaces.embedabbles.IInformation;
import fr.univtln.m2dapm.stockmanagement.interfaces.equipment.IEquipment;

import java.util.Collection;

/**
 * Created by Maxime Gajovski on 07/12/2016.
 */
public interface ISchool extends IAbstractEntity<Long>, ILocal{

    Collection<IClassRoom>  getClassRooms();
    Collection<IEquipment>  getEquipments();
    Collection<ITeacher>    getTeachers();
}
