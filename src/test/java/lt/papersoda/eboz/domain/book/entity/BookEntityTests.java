package lt.papersoda.eboz.domain.book.entity;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BookEntityTests {
    @Test
    void book_id_is_only_obtainable() {
        var book = new Book();

        assertThat(book.getId()).isNull();
    }

    @Test
    void book_name_is_settable_and_obtainable() {
        var book = new Book();
        book.setName("book");

        assertThat(book.getName()).isEqualTo("book");
    }
}
