package pl.coderslab.book;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/book-form")
public class BookFormController {
    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    public BookFormController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBook(Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("authors", authorDao.findAll());
        model.addAttribute("book", new Book());
        return "book/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String save(@Valid Book book, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("publishers", publisherDao.findAll());
            model.addAttribute("authors", authorDao.findAll());
            return "book/add";
        }
        bookDao.save(book);
        return "redirect:/book-form/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("books", bookDao.findAll());
        return "book/list";
    }

    @RequestMapping(value = "/remove", method = RequestMethod.GET)
    public String remove(@RequestParam Long id) {
        bookDao.delete(bookDao.findById(id));
        return "redirect:/book-form/list";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editBook(@RequestParam Long id, Model model) {
        model.addAttribute("publishers", publisherDao.findAll());
        model.addAttribute("book", bookDao.findById(id));
        return "book/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String update(Book book, Model model) {
        bookDao.update(book);
        return "redirect:/book-form/list";
    }

    @RequestMapping(value = "/confirm", method = RequestMethod.GET)
    public String confirm(@RequestParam Long id, Model model) {
        model.addAttribute("id", id);
        return "book/confirm";
    }
}
