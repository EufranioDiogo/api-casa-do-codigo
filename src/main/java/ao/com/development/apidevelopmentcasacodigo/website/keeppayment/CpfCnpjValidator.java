package ao.com.development.apidevelopmentcasacodigo.website.keeppayment;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CpfCnpjValidator implements ConstraintValidator<CpfCnpj, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return true;
        }

        CPFValidator cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);

        if (cpfValidator.isValid(s, constraintValidatorContext)) {
            return true;
        }

        CNPJValidator cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

        if (cnpjValidator.isValid(s, constraintValidatorContext)) {
            return true;
        }
        return false;
    }
}
