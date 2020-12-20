package lt.papersoda.eboz.web.rest.v1;

import lt.papersoda.eboz.domain.book.entity.Book;
import lt.papersoda.eboz.domain.book.repository.BookRepository;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@WebMvcTest(BookController.class)
public class BookControllerIntTests {
    @MockBean
    private BookRepository bookRepository;

    @Autowired
    MockMvc mockMvc;

    @Test
    void shouldCreateMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    public void get_all_books_returns_books() throws Exception {
        when(bookRepository.findAll()).thenReturn(List.of(
                new Book().setName("book1"),
                new Book().setName("book2")
        ));

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/books"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()", Matchers.is(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("book1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("book2"));
    }
}
