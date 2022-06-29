package pl.coderslab.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByRating(int rating);

    List<Book> findAllByRatingGreaterThan(int rating);

    List<Book> findByTitle(String title);

    List<Book> findByCategory(Category category);

    List<Book> findByCategoryAndPublisherAndRating(Category category, Publisher publisher, int rating);

    List<Book> findByCategoryId(Long id);

    @Query("select b from Book b where b.title=?1")
    List<Book> findByTitleQuery(String title);

    @Query("select b from Book b where b.category=?1 and b.publisher=?2")
    List<Book> findByCategoryQuery(Category category, Publisher publisher);

}
