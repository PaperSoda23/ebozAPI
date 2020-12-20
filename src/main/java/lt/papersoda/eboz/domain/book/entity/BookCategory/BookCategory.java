package lt.papersoda.eboz.domain.book.entity.BookCategory;

import lt.papersoda.eboz.domain.book.entity.Book;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "book_category", schema = "public")
public class BookCategory implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private BookCategoryId id;

    @ManyToOne
    @MapsId("bookId")
    private Book book;

    @ManyToOne
    @MapsId("bookCategoryId")
    private Category category;
}