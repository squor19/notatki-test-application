package martynenko.test.notatki.service;

import martynenko.test.notatki.entity.Notatka;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotatkaService {

    // CRUD

    public void AddNotatka(Notatka notatka) {

    }

    public List<Notatka> findNotatkasByTitle(String title) {
        return null;
    }

    public void editNotatka(String title) {

    }

    public void deleteNotatka(String title) {

    }

    public List<Notatka> showAllNotatkas() {
        return null;
    }
}
