package lt.papersoda.eboz.domain.book.entity.BookCategory;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookCategoryId implements Serializable {
    private Long bookId;
    private Long bookCategoryId;

    public BookCategoryId(Long bookId, Long bookCategoryId) {
        this.bookId = bookId;
        this.bookCategoryId = bookCategoryId;
    }

    public BookCategoryId() { }

    public Long getBookId() {
        return bookId;
    }

    public Long getBookCategoryId() {
        return bookCategoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookCategoryId that = (BookCategoryId) o;
        return Objects.equals(bookId, that.bookId) && Objects.equals(bookCategoryId, that.bookCategoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, bookCategoryId);
    }
}
