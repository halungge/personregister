package ch.mlz.preg;

import ch.mlz.preg.model.Person;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PersonRepository {
    private Map<Long, Person> persons = new HashMap<>();

    public Person save(Person person) {
        if(person.getId() == null){
            final Long max = Collections.max(persons.keySet());
            person.setId(max + 1);
        }
        persons.put(person.getId(), person);
        return person;
    }

    public Optional<Person> getPerson(Long id){
       return Optional.ofNullable(persons.get(id));
    }
}
