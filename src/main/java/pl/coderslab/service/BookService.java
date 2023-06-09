package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public void save(Book book) {
        bookRepository.save(book);
    }

    public Book findById(Long id) {
        return bookRepository.findById(id).get();
        // return bookDao.findById(id);
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
        //return bookDao.findAll();
    }

    public List<Book> findByRating(int rating) {
        return bookRepository.findByRating(rating);
    }

    public List<Book> findByRatingBetween(int min, int max) {
        return bookRepository.findByRatingBetween(min, max);
    }

    public List<Book> findByPublisherIsNotNull() {
        return bookRepository.findByPublisherIsNotNull();
    }

    public List<Book> findByPublisher(Publisher publisher) {
        return bookRepository.findByPublisher(publisher);
    }

    public List<Book> findByAuthor(Author author) {
        return bookRepository.findByAuthorsContains(author);
    }


    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
    public List<Book> findByCategory(Category category) {
        return bookRepository.findByCategory(category);
    }
    public List<Book> findByCategoryId(Long id) {
        return bookRepository.findByCategoryId(id);
    }
    public Optional<Book> findFirstByCategoryOrderByTitle(Category category) {
        return bookRepository.findFirstByCategoryOrderByTitle(category, PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "title")))
                .stream()
                .findFirst();
    }

    public void update(Book book) {
        bookRepository.save(book);
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
