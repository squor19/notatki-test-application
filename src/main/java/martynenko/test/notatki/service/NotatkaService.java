package martynenko.test.notatki.service;

import martynenko.test.notatki.entity.Notatka;
import martynenko.test.notatki.repository.NotatkaRepository;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotatkaService {

    // CRUD

    private final NotatkaRepository repository;

    private final Logger logger = LoggerFactory.getLogger(NotatkaService.class);

    @Autowired
    public NotatkaService(NotatkaRepository repository) {
        this.repository = repository;
    }

    public String addNotatka(Notatka notatka) {
        String title = notatka.getTitle();
        notatka.setLocalDateAndTime(LocalDateTime.now());
        repository.save(notatka);
        if (repository.findByTitle(title) != null) {
            logger.info("note: " + title + " was added to the db");
            return "The note was successfully added!";
        } else {
            return "The note with that title already exists!";
        }
    }

    public List<Notatka> findNotatkasByTitle(String title) {
        return repository.findByTitleContaining(title);
    }

    public String updateNotatka(Notatka notatka) {
        String title = notatka.getTitle();
        if(repository.findByTitle(title) != null) {
            repository.save(new Notatka(notatka.getTitle(), notatka.getContent(), LocalDateTime.now()));
            if(repository.findByTitle(title).getContent().equals(notatka.getContent())) {
                logger.info("note: " + title + " was changed");
                return "Note was successfully changed! ;)";
            } else {
                logger.error("note: " + title + " failed to change");
                return "Failed to change the note ';(((";
            }
        } else {
            return "Note with that title doesn't exist '_' ";
        }
    }

    public String deleteNotatka(String title) {
        Notatka temp = repository.findByTitle(title);
        if (temp != null) {
            repository.delete(temp);
            if (repository.findByTitle(title) == null) {
                logger.info("note: " + title + " removed");
                return "Note was successfully removed";
            } else {
                logger.error("note: " + title + " failed to remove");
                return "Failed to delete the note";
            }
        } else {
            return "Note with that title doesn't exist";
        }
    }

    public List<Notatka> showAllNotatkas() {
        logger.info("accessed to all notes");
        return repository.findAll();
    }
}
