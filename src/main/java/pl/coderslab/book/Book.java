package pl.coderslab.book;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 5)
    private String title;
    @Range(min = 1, max = 10)
    private int rating;
    @Size(max = 600)
    private String description;
    @NotNull
    @ManyToOne
    private Publisher publisher;
    @ManyToOne
    private Category category;
    @Size(min = 1)
    @NotEmpty
    @ManyToMany
    private List<Author> authors;

}
