package lt.papersoda.eboz.domain.book.entity;

import lt.papersoda.eboz.domain.book.entity.BookCategory.BookCategory;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Book implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "category")
    private List<BookCategory> bookCategories = new ArrayList<>();

    @Column
    private String name;

    @Column(name = "created_at")
    private Instant createdAt = Instant.now();

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "[book]=(" + "id=" + id + "name=" + name + "created=" + createdAt + ")";
    }
}
