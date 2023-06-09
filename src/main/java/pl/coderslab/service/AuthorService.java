package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.entity.Author;
import pl.coderslab.repository.AuthorRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public void save(Author author) {
        authorRepository.save(author);
    }

    public Author findById(Long id) {
        return authorRepository.findById(id).get();
    }

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public void update(Author author) {
        authorRepository.save(author);
    }

    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    public List<Author> findByEmailStartsWith(String prefix) {
        return authorRepository.findByEmailStartsWith(prefix);
    };
    public List<Author> findByPeselStartsWith(String prefix) {
        return authorRepository.findByPeselStartsWith(prefix);
    }
}
