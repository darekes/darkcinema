package mas.Registration;

import mas.Person.ClientRepository;
import mas.Person.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Darek on 2018-06-11.
 */

@Controller
public class ClientRegistrationController {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRegistrationFormValidator clientRegistrationFormValidator;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        Object target = webDataBinder.getTarget();
        if(target.getClass() == ClientRegistrationForm.class){
            webDataBinder.setValidator(clientRegistrationFormValidator);
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String getRegistrationView(Model model){
        ClientRegistrationForm registrationForm = new ClientRegistrationForm();
        model.addAttribute("registrationForm", registrationForm);
        return "registration";
    }

    @RequestMapping("/registration-successful")
    public String getRegistrationSuccessfulView(){
        return "registration-successful";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String saveRegistration(Model model, @ModelAttribute("registrationForm")
                                   @Validated ClientRegistrationForm clientRegistrationForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "registration";
        }

        try{
            clientService.insertClient(clientRegistrationForm);
        } catch(Exception e){
            model.addAttribute("errorMessage", "Error: " + e.getMessage());
            return "registration";
        }

        return "registration-successful";
    }
}
