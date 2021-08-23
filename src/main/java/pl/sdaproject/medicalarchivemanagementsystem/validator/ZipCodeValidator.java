package pl.sdaproject.medicalarchivemanagementsystem.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ZipCodeValidator implements ConstraintValidator<ZipCodeConstraint, String> {

    @Override
    public void initialize(ZipCodeConstraint constraint) {
    }

    @Override
    public boolean isValid(String zipCode, ConstraintValidatorContext constraintValidatorContext) {
        return zipCode == null || zipCode.matches("[0-9]{2}-[0-9]{3}");
    }
}
