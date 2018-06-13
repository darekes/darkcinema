package mas.Clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Darek on 2018-06-11.
 */
@Controller
@RequestMapping("/clients")
public class ClientsController {

    @Autowired
    private ClientService clientService;

    @RequestMapping
    public String getClientView(Model model){
        model.addAttribute("clients", clientService.getClientList());
        return "clients";
    }
}
