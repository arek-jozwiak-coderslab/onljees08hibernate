package pl.coderslab.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        String[] a = new String[] {"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }

    @RequestMapping(value = "/simple", method = RequestMethod.GET)
    public String simple(Model model) {
        Student student = new Student("Jan", "Kowalski");

        model.addAttribute("student", student);
        return "student/simple";
    }

    @RequestMapping(value = "/simple", method = RequestMethod.POST)
    public String processSimple(Student student, Model model) {
        model.addAttribute("student", student);
        return "student/success";
    }
}
