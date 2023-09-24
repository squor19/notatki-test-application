package martynenko.test.notatki.api;

import martynenko.test.notatki.entity.Notatka;
import martynenko.test.notatki.service.NotatkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NotatkaController {

    private final NotatkaService service;

    @Autowired
    public NotatkaController(NotatkaService service) {
        this.service = service;
    }

    @GetMapping("/{title}")
    public List<Notatka> getNotatkaByTitle(@PathVariable String title) {
        return service.findNotatkasByTitle(title);
    }

    @GetMapping
    public List<Notatka> getAllNotatkas() {
        return service.showAllNotatkas();
    }

    @PostMapping
    public String addNotatka(@RequestBody Notatka notatka) {
        return service.addNotatka(notatka);
    }

    @PutMapping
    public String editNotatka(@RequestBody Notatka notatka) {
        return service.updateNotatka(notatka);
    }

    @DeleteMapping("/{title}")
    public String deleteNotatka(@PathVariable String title) {
        return service.deleteNotatka(title);
    }

}
