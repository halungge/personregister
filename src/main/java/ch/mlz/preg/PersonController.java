package ch.mlz.preg;

import ch.mlz.preg.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody Person person) {
        return null;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(Long id) {

    }

    @GetMapping
    public List<Person> findAll() {
        return null;
    }

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id) {
        return null;
    }
}
