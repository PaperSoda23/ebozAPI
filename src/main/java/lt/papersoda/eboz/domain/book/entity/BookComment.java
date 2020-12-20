package lt.papersoda.eboz.domain.book.entity;

import lt.papersoda.eboz.domain.user.entity.User;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book_comment", schema = "public")
public class BookComment implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fk_book")
    private Book book;

    @OneToOne
    @JoinColumn(name = "fk_user")
    private User user;

    @OneToMany
    @JoinColumn(name = "fk_book")
    public List<BookCommentVote> commentVotes = new ArrayList<>();
}