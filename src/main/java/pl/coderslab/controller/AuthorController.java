package pl.coderslab.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Author;
import pl.coderslab.service.AuthorService;

import java.util.List;
import java.util.Objects;

@RestController
class AuthorController {

    private final AuthorService authorService;

    AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    // create author
    @PostMapping(path = "/author")
    void save(@RequestParam String firstName, @RequestParam String lastName) {

        Author author = new Author();

        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorService.save(author);
    }

    // gets author by id
    @GetMapping(path = "/author/{id}", produces = "text/plain;charset=utf-8")
    String findById(@PathVariable Long id) {

        Author author = authorService.findById(id);

        return author != null ? author.toString() : "Nie znaleziono autora o podanym id " + id;
    }

    @GetMapping(path = "/authors", produces = "text/plain;charset=utf-8")
    String findAll() {

        final List<Author> authors = authorService.findAll();

        return authors.toString();
    }
    // updates author
    @PutMapping(path = "/author/{id}")
    void update(@PathVariable Long id, @RequestParam String firstName, @RequestParam String lastName) {

        final Author author = authorService.findById(id);

        if (Objects.nonNull(author)) {
            author.setFirstName(firstName);
            author.setLastName(lastName);

            authorService.update(author);
        }
    }

    // deletes author by id
    @DeleteMapping(path = "/author/{id}")
    void deleteById(@PathVariable Long id) {
        authorService.deleteById(id);
    }
}
