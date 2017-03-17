package org.estore.finki;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by filip on 17.3.17.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Source code location: " +
                "<a href='https://github.com/Kirkhammett/soa-spring'>soa-spring</a>" +
                "</br><p>Endpoints</p><ul>" +
                "<li>/customer</li>" +
                "<li>/order</li>" +
                "<li>/product</li></ul>";
    }
}
