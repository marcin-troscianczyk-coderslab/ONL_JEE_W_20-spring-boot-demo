package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.CategoryService;
import pl.coderslab.service.PublisherService;

import jakarta.validation.Valid;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
class BookFormController {

    private final BookService bookService;
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    // wyswietlenie formularza dodawania ksiazki
    @GetMapping(path = "/book/add")
    String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book/add";
    }

    // obsluga formularza dodawania ksiazki
    @PostMapping(path = "/book/add")
    String processAddBookForm(@Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "book/add";
        }

        bookService.save(book);

        return "redirect:/book/list";
    }

    @GetMapping(path = "/book/edit")
    String showEditBookForm(@RequestParam Long id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "book/edit";
    }

    @PostMapping(path = "/book/edit")
    String processEditBookForm(@Valid Book book, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "book/edit";
        }

        bookService.update(book);

        return "redirect:/book/list";
    }

    @GetMapping(path = "/book/remove")
    String processRemoveBook(@RequestParam Long id) {

        bookService.deleteById(id);

        return "redirect:/book/list";
    }

    // wyswietlanie listy wszystkich ksiazek
    @GetMapping(path = "/book/list")
    String showBookList(Model model) {

        List<Book> books = bookService.findAll();
        model.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping(path = "/book/search")
    String showSearchBookForm() {
        return "book/search";

    }

    // np. http://localhost:8080/book/search?title=Java+techniki+programowania
    @GetMapping(path = "/book/search", params = "title")
    String findByTile(@RequestParam String title, Model model) {

        List<Book> books = bookService.findByTitle(title);
        model.addAttribute("books", books);

        return "book/list";

    }

    @GetMapping(path = "/book/search", params = "rating")
    String findByRating(@RequestParam int rating, Model model) {

        List<Book> books = bookService.findByRating(rating);
        model.addAttribute("books", books);

        return "book/list";

    }

    @GetMapping(path = "/book/search", params = {"min", "max"})
    String findByRatingBetween(@RequestParam int min, @RequestParam int max, Model model) {

        List<Book> books = bookService.findByRatingBetween(min, max);
        model.addAttribute("books", books);

        return "book/list";

    }

    // np. http://localhost:8080/book/search?id=2
    @GetMapping(path = "/book/search", params = "id")
    String findByCategory(Category category, Model model) {

        List<Book> books = bookService.findByCategory(category);
        model.addAttribute("books", books);

        return "book/list";
    }

    // np. http://localhost:8080/book/search?categoryId=2
    @GetMapping(path = "/book/search", params = "categoryId")
    String findByCategoryId(@RequestParam Long categoryId, Model model) {

        List<Book> books = bookService.findByCategoryId(categoryId);
        model.addAttribute("books", books);

        return "book/list";
    }

    // http://localhost:8080/book/search/category?id=3
    @GetMapping(path = "/book/search/category")
    String findFirstByCategoryOrderByTitle(Category category, Model model) {

        Optional<Book> book = bookService.findFirstByCategoryOrderByTitle(category);

        List<Book> books = book.map(Collections::singletonList).orElse(Collections.emptyList());

        model.addAttribute("books", books);

        return "book/list";
    }
    @GetMapping(path = "/book/search/publisher", params = "id")
    String findByPublisher(Publisher publisher, Model model) {

        List<Book> books = bookService.findByPublisher(publisher);

        model.addAttribute("books", books);

        return "book/list";
    }

    @GetMapping(path = "/book/search/author", params = "id")
    String findByAuthor(Author author, Model model) {

        List<Book> books = bookService.findByAuthor(author);

        model.addAttribute("books", books);

        return "book/list";
    }

    // umieszczenie w modelu pod kluczem 'publishers' kolekcji obiektow Publisher
    @ModelAttribute("publishers")
    Collection<Publisher> findAllPublishers() {
        System.out.println("Ala ma kota");
        return publisherService.findAll();
    }

    @ModelAttribute("authors")
    Collection<Author> authors() {
        return authorService.findAll();
    }

    @ModelAttribute("categories")
    Collection<Category> categories() {
        return categoryService.findAll();
    }
}
