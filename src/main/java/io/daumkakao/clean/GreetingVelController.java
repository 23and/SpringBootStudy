package io.daumkakao.clean;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingVelController {
	private static final Logger logger = Logger.getLogger(GreetingVelController.class);

    @RequestMapping("greetingVel")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    	
    	logger.info("This is an info log entry");
    	logger.error("This is an error log entry");
		
        model.addAttribute("name", name);
        return "greetingVel";
    }
}
