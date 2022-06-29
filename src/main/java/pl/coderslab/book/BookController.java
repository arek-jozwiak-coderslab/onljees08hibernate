package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/book")
public class BookController {

    private final Validator validator;
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookController(Validator validator, BookDao bookDao, PublisherDao publisherDao, BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.validator = validator;
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        Book byId = bookDao.findById(1l);
        byId.setTitle(" Other book about java");
        bookDao.update(byId);
        return "test";
    }

    @RequestMapping("/add")
    @ResponseBody
    public String add() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisherDao.save(publisher);

        Book book = new Book();
        book.setPublisher(publisher);
        book.setTitle("Java 2 podstawy");
        book.setRating(5);

        Set<ConstraintViolation<Book>> constraintViolations = validator.validate(book);
        if (!constraintViolations.isEmpty()) {
            constraintViolations.forEach(
                    cv -> System.out.println(cv.getPropertyPath() + " : " + cv.getMessage())
            );
        } else {
            bookDao.save(book);
        }

        return "test";
    }

    @RequestMapping("/test-rating")
    @ResponseBody
    public String testRating(@RequestParam int rating) {
        bookDao.findAllByRating(rating).stream()
                .forEach(b -> System.out.println(b.getTitle()));
        return "test";
    }

    @RequestMapping("/test-repo")
    @ResponseBody
    public String testRepo() {
        bookRepository.findByTitle("111").forEach(b ->
                System.out.println(b.getTitle() + " :" + b.getId()));
        System.out.println("---------");

        bookRepository.findByCategoryId(1l).forEach(b ->
                System.out.println(b.getTitle() + " :" + b.getId()));
        System.out.println("---------");

        Category one = categoryRepository.getOne(1l);

        System.out.println("---------");
        bookRepository.findByCategory(one).forEach(b ->
                System.out.println(b.getTitle() + " :" + b.getId()));
        return "test";
    }

}
