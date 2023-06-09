package pl.coderslab.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Publisher;

import java.util.List;

@Service
@Transactional
public class PublisherService {

    private PublisherDao publisherDao;

    public PublisherService(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    public void save(Publisher publisher) {
        publisherDao.save(publisher);
    }

    public Publisher findById(Long id) {
        return publisherDao.findById(id);
    }

    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }

    public void update(Publisher publisher) {
        publisherDao.update(publisher);
    }

    public void deleteById(Long id) {
        publisherDao.deleteById(id);
    }
}
