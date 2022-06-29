package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class ValidationController {
    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @RequestMapping("/validate")
    @ResponseBody
    public String validate() {
        Book book = new Book();
        book.setTitle("aa");
        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);

        if (constraintViolations.isEmpty()) {
            System.out.println("IS OK");
        } else {
            constraintViolations
                    .forEach(cv ->
                            System.out.println(cv.getPropertyPath() + " : " + cv.getMessage()));
        }

        return "test";
    }
}
