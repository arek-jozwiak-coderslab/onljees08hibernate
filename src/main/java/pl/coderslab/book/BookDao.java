package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Book book) {
        entityManager.persist(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book book) {
        entityManager.merge(book);
    }

    public void delete(Book book) {
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public List<Book> findAll() {
        Query query = entityManager.createQuery("select b from Book b");
        List<Book> resultList = query.getResultList();
        return resultList;
    }

    public List<Book> findAllSimple() {
        return entityManager
                .createQuery("select b from Book b")
                .getResultList();
    }


    public List<Book> findAllByRating(int rating) {
        return entityManager
                .createQuery("select b from Book b where b.rating =:r")
                .setParameter("r", rating)
                .getResultList();
    }
}
