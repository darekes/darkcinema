package mas.Clients;

import mas.Homepage.HomepageController;
import mas.Registration.ClientRegistrationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Darek on 2018-06-13.
 */
@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(HomepageController.class);

    public void fillInitialData(){
        Client client1 = new Client();
        client1.setFirstName("Darek");
        client1.setLastName("Samsel");
        client1.setEmailAddress("dsamsel@mail.com");
        client1.setBirthDate(LocalDate.of(1995, Month.APRIL, 22));
        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setFirstName("Jan");
        client2.setLastName("Kowalski");
        client2.setEmailAddress("jkowlaski@mail.com");
        client2.setBirthDate(LocalDate.of(1991, Month.MAY, 10));
        clientRepository.save(client2);

        Client client3 = new Client();
        client3.setFirstName("Piotr");
        client3.setLastName("Nowakowski");
        client3.setEmailAddress("pnowakowski@mail.com");
        client3.setBirthDate(LocalDate.of(1999, Month.JUNE, 05));
        clientRepository.save(client3);
    }

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
}
