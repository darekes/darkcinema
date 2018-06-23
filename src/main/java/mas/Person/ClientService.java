package mas.Person;

import mas.Discounts.LoyaltyProgram;
import mas.Homepage.HomepageController;
import mas.Registration.ClientRegistrationForm;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darek on 2018-06-13.
 */
@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    private EmailValidator emailValidator = EmailValidator.getInstance();

    private static final Logger LOGGER = LoggerFactory.getLogger(HomepageController.class);

    public boolean isEmailUsed(String emailAddress){
        List<Client> list = clientRepository.findByEmailAddress(emailAddress);
        return !list.isEmpty();
    }

    public boolean isBirthDateFromFuture(LocalDate birthDate){
        return birthDate.isAfter(LocalDate.now());
    }

    public void insertClient(ClientRegistrationForm registrationForm){
        Client client = new Client();
        client.setFirstName(registrationForm.getFirstName());
        client.setLastName(registrationForm.getLastName());
        client.setEmailAddress(registrationForm.getEmailAddress());
        client.setBirthDate(registrationForm.getBirthDate());
        clientRepository.save(client);
    }

    public List<Client> getClientList(){
        List<Client> list = new ArrayList<>();
        Iterable<Client> iterable = clientRepository.findAll();
        iterable.forEach(list::add);
        return list;
    }

    public boolean isEmailValid(String emailAddress){
        return emailValidator.isValid(emailAddress);
    }

    public Client getClientById(Long id){
        List<Client> list = new ArrayList<>();
        Iterable<Client> iterable = clientRepository.findAll();
        iterable.forEach(list::add);
        for(Client client : list){
            if(client.getId().equals(id)){
                return client;
            }
        }
        return null;
    }

    public void incrementVisits(Client client){
        client.setNumberOfVisits(client.getNumberOfVisits() + 1);
        clientRepository.save(client);
    }

    public boolean isClientAbleToGetDiscount(Client client, LoyaltyProgram loyaltyProgram){
        return client.getNumberOfVisits() >= loyaltyProgram.getMinimumVisits();
    }
}
