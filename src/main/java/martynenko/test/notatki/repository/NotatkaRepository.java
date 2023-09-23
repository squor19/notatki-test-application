package martynenko.test.notatki.repository;

import martynenko.test.notatki.entity.Notatka;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotatkaRepository extends JpaRepository<Notatka, String> {
}
