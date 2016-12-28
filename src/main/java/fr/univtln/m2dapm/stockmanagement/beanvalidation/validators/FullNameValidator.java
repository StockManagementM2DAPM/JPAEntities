package fr.univtln.m2dapm.stockmanagement.beanvalidation.validators;

import fr.univtln.m2dapm.stockmanagement.beanvalidation.annotations.FullName;
import fr.univtln.m2dapm.stockmanagement.embeddables.interfaces.IFullName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by toms on 12/28/16.
 */
public class FullNameValidator implements ConstraintValidator<FullName, IFullName> {

    private Boolean bool = true;

    @Override
    public void initialize(FullName fullName) {
    }

    /**
     * Defines conditions to have for validate Fullname's instance
     * @param iFullName
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(IFullName iFullName, ConstraintValidatorContext constraintValidatorContext) {
        if(iFullName.getFirstName() == null ||iFullName.getLastName() == null){
            bool = false;
        }
        else if (iFullName.getFirstName().length() < 2 ||iFullName.getFirstName().length() > 31||iFullName.getLastName().length() < 2 ||iFullName.getLastName().length() > 31){
            bool = false;
        }
        return bool;
    }
}
