package ao.com.development.apidevelopmentcasacodigo.website.keeppayment;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = {CpfCnpjValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CpfCnpj {
    String message() default "{ ao.com.development.apidevelopmentcasacodigo.CpfCnpj.message }";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
