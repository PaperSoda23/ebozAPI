package lt.papersoda.eboz.domain.book.service;

import lt.papersoda.eboz.domain.book.entity.Book;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BookServiceTests {
    @Autowired
    BookService bookService;

    @Test
    void test_required_components_injected() {
        assertThat(bookService).isNotNull();
    }

    @Test
    void returns_as_much_books_as_limit_specifies() {
        var limit = 1;

        List<Book> books = bookService.getNewestBooks(limit);

        assertThat(books.size()).isEqualTo(limit);
    }

    @Test
    void returns_newest_books() {
        var limit = 2;

        List<Book> books = bookService.getNewestBooks(limit);

        assertThat(books.get(0).getCreatedAt()
                    .isAfter(books.get(1).getCreatedAt()))
                        .isTrue();
    }

    @Nested
    class Errors {
        @Test
        void errors_when_limit_is_null() {
            assertThrows(IllegalArgumentException.class, () -> bookService.getNewestBooks(null));
        }

        @Test
        void errors_when_limit_is_0() {
            assertThrows(IllegalArgumentException.class, () -> bookService.getNewestBooks(0));
        }

        @Test
        void errors_when_limit_is_negative() {
            assertThrows(IllegalArgumentException.class, () -> bookService.getNewestBooks(-1));
        }
    }
}
