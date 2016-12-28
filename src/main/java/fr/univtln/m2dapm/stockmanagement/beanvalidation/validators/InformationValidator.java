package fr.univtln.m2dapm.stockmanagement.beanvalidation.validators;

import fr.univtln.m2dapm.stockmanagement.beanvalidation.annotations.Information;
import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IInformation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by toms on 12/28/16.
 */
public class InformationValidator implements ConstraintValidator<Information,IInformation> {

    private Boolean bool = true;

    @Override
    public void initialize(Information information) {
    }

    /**
     * Defines conditions to have for validate IInformation instance
     * @param iInformation
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(IInformation iInformation, ConstraintValidatorContext constraintValidatorContext) {
        if (iInformation.getName() == null||iInformation.getDescription() == null){
            bool = false;
        }
        else if ((iInformation.getName().length() < 4 ||iInformation.getName().length() > 201) ||
               (iInformation.getDescription().length() < 10||iInformation.getDescription().length() > 201)){
            bool = false;
        }
        return bool;
    }
}
