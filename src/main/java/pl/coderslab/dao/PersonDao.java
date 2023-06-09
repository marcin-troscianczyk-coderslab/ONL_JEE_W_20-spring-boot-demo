package pl.coderslab.dao;

import pl.coderslab.entity.Person;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PersonDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void save(Person person) {
        entityManager.persist(person);
    }

    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    public List<Person> findAll() {
        return entityManager.createQuery("select p from Person p")
                        .getResultList();
    }

    public void update(Person person) {
        entityManager.merge(person);
    }

    public void deleteById(Long id) {
        Person person = findById(id);
        entityManager.remove(entityManager.contains(person) ? person : entityManager.merge(person));
    }
}
