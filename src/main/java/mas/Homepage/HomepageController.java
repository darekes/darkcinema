package mas.Homepage;

import mas.Person.ClientService;
import mas.Utils.InitialDataPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Darek on 2018-06-11.
 */
@Controller
public class HomepageController {

    @Autowired
    InitialDataPopulator populator;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HomepageController.class);

    @RequestMapping("/")
    public String getHomepage(){
        populator.fillInitialData();
        return "homepage";
    }
}