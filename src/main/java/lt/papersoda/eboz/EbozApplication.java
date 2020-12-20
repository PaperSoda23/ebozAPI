package lt.papersoda.eboz;

import lt.papersoda.eboz.domain.book.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EbozApplication {
    public static void main(String[] args) {
        SpringApplication.run(EbozApplication.class, args);
    }

    @Autowired
    private BookRepository bookRepository;
}
