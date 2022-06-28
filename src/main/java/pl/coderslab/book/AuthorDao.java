package pl.coderslab.book;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;
    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public List<Author> findAll() {
        Query query = entityManager.createQuery("select a from Author a");
        List<Author> resultList = query.getResultList();
        return resultList;
    }


}
