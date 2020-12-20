package lt.papersoda.eboz;

import lt.papersoda.eboz.domain.book.entity.Book;
import lt.papersoda.eboz.domain.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EbozApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(EbozApplication.class, args);
    }

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) {

        var books = List.of(
                new Book().setName("first book"),
                new Book().setName("second book")
        );

        bookRepository.saveAll(books);
        bookRepository.flush();
    }
}
