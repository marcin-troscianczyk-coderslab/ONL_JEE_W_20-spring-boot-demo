package pl.coderslab.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Category;
import pl.coderslab.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Override
    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    List<Book> findAll();

    @Override
    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    Optional<Book> findById(Long id);

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    List<Book> findByRating(int rating);

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    List<Book> findByPublisherIsNotNull();

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    @Query("select b from Book b where b.publisher = :publisher")
    List<Book> findByPublisher(@Param("publisher") Publisher publisher); // select b from Book b where b.publisher = :publisher

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    List<Book> findByAuthorsContains(Author author);

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    @Query("select b from Book b where b.title = :title")
    List<Book> findByTitle(@Param("title") String title);

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    @Query("select b from Book b where b.category = :category")
    List<Book> findByCategory(@Param("category") Category category);

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    List<Book> findByCategoryId(Long id);

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    @Query("select b from Book b where b.category = :category")
    Page<Book> findFirstByCategoryOrderByTitle(@Param("category") Category category, Pageable pageable); // select b from Book b where b.category = :category order by b.title asc limit 1

    @EntityGraph(attributePaths = {"publisher", "authors", "category"})
    @Query("select b from Book b where b.rating between :min and :max")
    List<Book> findByRatingBetween(@Param("min") int min, @Param("max") int max);
}
