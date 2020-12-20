package lt.papersoda.eboz.domain.book.entity.BookCategory;

import lt.papersoda.eboz.domain.book.entity.Book;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class Category implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "book")
    private List<BookCategory> books = new ArrayList<>();
}
