package ch.mlz.preg;

import ch.mlz.preg.model.Person;

class PersonService {
    private PersonRepository repo;

    public PersonService(PersonRepository repo) {
        this.repo = repo;
    }

    public Person savePerson(Person person){
        return repo.save(person);

    }
}
