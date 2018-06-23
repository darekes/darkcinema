package mas.Seance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Darek on 2018-06-21.
 */

@Transactional
@Controller
public class SeanceController {

    @Autowired
    SeanceService seanceService;

    @RequestMapping(value = { "/seances" }, method = RequestMethod.GET)
    public String getSeances(Model model){

        List<Seance> seances = seanceService.getAllSeances();
        model.addAttribute("seances",seances);
        return "seances";
    }
}
