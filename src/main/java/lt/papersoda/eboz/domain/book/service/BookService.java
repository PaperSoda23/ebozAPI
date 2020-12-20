package lt.papersoda.eboz.domain.book.service;

import lt.papersoda.eboz.domain.book.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {
    final EntityManager entityManager;

    @Autowired
    public BookService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Book> getNewestBooks(Integer limit) {
        if (ObjectUtils.isEmpty(limit) || limit <= 0)
            throw new IllegalArgumentException("limit should be at least 1");

        return entityManager
                .createQuery("SELECT b FROM Book b ORDER BY b.createdAt DESC", Book.class)
                .setMaxResults(limit)
                .getResultList();
    }
}
