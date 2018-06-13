package mas.Discounts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Darek on 2018-06-11.
 */
@Controller
public class DiscountsController {
    @RequestMapping("/discounts")
    public String getDiscounts(){
        return "discounts";
    }
}
