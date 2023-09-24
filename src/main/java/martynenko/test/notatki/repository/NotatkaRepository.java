package martynenko.test.notatki.repository;

import martynenko.test.notatki.entity.Notatka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotatkaRepository extends JpaRepository<Notatka, Long> {

    public List<Notatka> findAllByTitle(String title);
    public Notatka findByTitle(String title);
    public List<Notatka> findByTitleContaining(String title);
}
