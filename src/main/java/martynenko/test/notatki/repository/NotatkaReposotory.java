package martynenko.test.notatki.repository;

import martynenko.test.notatki.entity.Notatka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotatkaReposotory extends JpaRepository<Notatka, String> {
}
