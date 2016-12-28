package fr.univtln.m2dapm.stockmanagement.beanvalidation.annotations;

import fr.univtln.m2dapm.stockmanagement.beanvalidation.validators.FullNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by toms on 12/28/16.
 */
/**
 * Default message if FullName's attribute instance not consistent
 *  message captured with  Set<ConstraintViolation<IFullname>> in JPAEntities
 *              see JPAEntities/Test/.../ValidationTest.java
 * @return
 */
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@Constraint(validatedBy = {FullNameValidator.class})
@Documented
public @interface FullName {

       String message() default "{fr.univtln.m2dapm.stockmanagement.teacher.fullname}";

        Class<?>[] groups() default {};

        Class<? extends Payload>[] payload() default {};

}
