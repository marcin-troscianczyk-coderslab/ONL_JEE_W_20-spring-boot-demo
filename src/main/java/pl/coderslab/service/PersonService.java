package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Person;

import java.util.List;

@Service
@Transactional
public class PersonService {

    private PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void save(Person person) {
        personDao.save(person);
    }

    public Person findById(Long id) {
        return personDao.findById(id);
    }

    public List<Person> findAll() {
        return personDao.findAll();
    }

    public void update(Person person) {
        personDao.update(person);
    }

    public void deleteById(Long id) {
        personDao.deleteById(id);
    }
}
