package pl.coderslab.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.BookService;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // create book
    @PostMapping(path = "/book")
    void save(@RequestParam String title, @RequestParam int rating, @RequestParam String description, @RequestParam String publisherName, @RequestParam("authorId") Long[] authorIds) {

        final Book book = new Book();

        book.setTitle(title);
        book.setRating(rating);
        book.setDescription(description);

        Publisher publisher = new Publisher();
        publisher.setName(publisherName);

        book.setPublisher(publisher);

        List<Author> authors =
                Arrays.stream(authorIds)
                        .map(Author::new)
                        .collect(Collectors.toList());

        book.setAuthors(authors);

        bookService.save(book);
    }

    // get book by id
    @GetMapping(path = "/book/{id}", produces = "text/plain;charset=utf-8")
    String findById(@PathVariable Long id) {

        final Book book = bookService.findById(id);

        return Objects.nonNull(book) ? book.toString() : "Nie znaleziono książki o podanym id " + id;
    }

    @GetMapping(path = "/books", produces = "text/plain;charset=utf-8")
    String findAll() {

        final List<Book> books = bookService.findAll();

        return books.toString();
    }

    @GetMapping(path = "/books", produces = "text/plain;charset=utf-8", params = "rating")
    String findAllByRating(@RequestParam int rating) {

        final List<Book> books = bookService.findByRating(rating);

        return books.toString();
    }

    @GetMapping(path = "/books/publisher", produces = "text/plain;charset=utf-8")
    String findAllByPublisherIsNull() {

        final List<Book> books = bookService.findByPublisherIsNotNull();

        return books.toString();
    }

    @GetMapping(path = "/books/publisher", produces = "text/plain;charset=utf-8", params = "id")
    String findAllByPublisher(Publisher publisher) {

        final List<Book> books = bookService.findByPublisher(publisher);

        return books.toString();
    }

    @GetMapping(path = "/books/author", produces = "text/plain;charset=utf-8", params = "id")
    String findAllByAuthor(Author author) {

        final List<Book> books = bookService.findByAuthor(author);

        return books.toString();
    }

    // update book
    @PutMapping(path = "/book/{id}")
    void update(@PathVariable Long id, @RequestParam String title, @RequestParam int rating, @RequestParam String description) {

        final Book book = bookService.findById(id);

        if (Objects.nonNull(book)) {

            book.setTitle(title);
            book.setRating(rating);
            book.setDescription(description);

            bookService.update(book);
        }
    }

    // delete book by id
    @DeleteMapping(path = "/book/{id}")
    void deleteById(@PathVariable Long id) {
        bookService.deleteById(id);
    }
}
