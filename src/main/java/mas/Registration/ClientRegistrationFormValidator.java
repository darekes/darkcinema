package mas.Registration;

import mas.Clients.ClientService;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Darek on 2018-06-13.
 */

@Component
public class ClientRegistrationFormValidator implements Validator{

    private EmailValidator emailValidator = EmailValidator.getInstance();

    @Autowired
    ClientService clientService;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClientRegistrationForm.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        ClientRegistrationForm registrationForm = (ClientRegistrationForm) object;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName", "NotEmpty.ClientRegistrationForm.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName", "NotEmpty.ClientRegistrationForm.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"emailAddress", "NotEmpty.ClientRegistrationForm.emailAddress");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"birthDate", "NotEmpty.ClientRegistrationForm.birthDate");

        if(!emailValidator.isValid(registrationForm.getEmailAddress())){
            errors.rejectValue("emailAddress", "Pattern.ClientRegistrationForm.emailAddress");
        }

        if(clientService.isEmailUsed(registrationForm.getEmailAddress())){
            errors.rejectValue("emailAddress", "Duplicate.ClientRegistrationForm.emailAddress");
        }

        if(clientService.isBirthDateFromFuture(registrationForm.getBirthDate())){
            errors.rejectValue("birthDate", "Pattern.ClientRegistrationForm.birthDate");
        }
    }

}
