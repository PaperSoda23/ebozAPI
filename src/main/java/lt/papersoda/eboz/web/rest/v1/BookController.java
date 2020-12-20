package lt.papersoda.eboz.web.rest.v1;

import lt.papersoda.eboz.domain.book.entity.Book;
import lt.papersoda.eboz.domain.book.repository.BookRepository;
import lt.papersoda.eboz.domain.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Validated
@RequestMapping("api/v1/books")
public class BookController {
    private final BookRepository bookRepository;
    private final BookService bookService;

    @Autowired
    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    // api/v1/books
    @GetMapping
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    // api/v1/books/new?limit=1
    @GetMapping("new")
    public List<Book> getNewestBooks(@RequestParam("limit") Integer limit) {
        try { return bookService.getNewestBooks(limit); }
        catch (IllegalArgumentException ex) { throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage()); }
    }
}
