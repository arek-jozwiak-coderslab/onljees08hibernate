package pl.coderslab.person;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/person")
public class PersonController {


    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public String simple(Model model) {
        Person build = Person.builder().login("are")
                .password("pass").email("arek@arek.pl").build();

        model.addAttribute("person", build);
        return "person/simple";
    }

    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    public String processSimple(
//            @RequestParam String login,
//            @RequestParam String password,
//            @RequestParam String email,
            Person person,
            Model model) {
        model.addAttribute("person", person);
        return "person/success";
    }
}
