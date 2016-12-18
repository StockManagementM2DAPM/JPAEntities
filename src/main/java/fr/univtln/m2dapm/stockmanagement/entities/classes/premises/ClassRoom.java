package fr.univtln.m2dapm.stockmanagement.entities.classes.premises;

import fr.univtln.m2dapm.stockmanagement.embeddables.classes.Information;
import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IInformation;
import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IInformationRead;
import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IInformationWrite;
import fr.univtln.m2dapm.stockmanagement.entities.classes.AbstractEntity;
import fr.univtln.m2dapm.stockmanagement.entities.interfaces.premises.IClassRoom;

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


    /* - - - - - - - - - - C O N S T R U C T O R S - - - - - - - - - - */

    protected ClassRoom(){

    }

    private ClassRoom(ClassRoom.Builder classroomBuilder){
        this.information = classroomBuilder.informationBuilder;
    }


    /* - - - - - - - - - - G E T T E R S - S E T T E R S  - - - - - - - - - - */

    @Override
    public IInformationRead getInformation() {
        return information;
    }


    /* - - - - - - - - - - T O - S T R I N G - - - - - - - - - - */

    @Override
    public String toString() {
        return  super.toString()        + "\n" +
                information.toString()     + "\n";
    }

    /* - - - - - - - - - - B U I L D E R - - - - - - - - - - */


    public static class Builder implements IInformationWrite<Builder> {

        private IInformation informationBuilder;

        public Builder(){
            informationBuilder = new Information();
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

        public IClassRoom build(){
            return new ClassRoom(this);
        }

    }
}
