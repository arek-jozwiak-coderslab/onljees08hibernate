package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/book")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;

    public BookController(BookDao bookDao, PublisherDao publisherDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
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
        bookDao.save(book);

        return "test";
    }

    @RequestMapping("/test-rating")
    @ResponseBody
    public String testRating(@RequestParam int rating) {
        bookDao.findAllByRating(rating).stream()
                .forEach(b -> System.out.println(b.getTitle()));
        return "test";
    }

}
