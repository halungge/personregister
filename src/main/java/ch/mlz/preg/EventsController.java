package ch.mlz.preg;

import ch.mlz.preg.model.Address;
import ch.mlz.preg.model.Person;
import ch.mlz.preg.model.events.PersonEventFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/persons/events")
public class EventsController {

    @PostMapping("/birth")
    public void birth(Person father, Person mother, Person child){
        PersonEventFactory.birth(LocalDateTime.now(), "me", child.getBirthday(), child);

    }

    @PostMapping("/move")
    public void move(List<Person> persons, Address newAddress){

    }

    @PostMapping("/change/name")
    public void changeName(Person person, String name, String firstName){

    }
    @PostMapping("/change/birthday")
    public void changeBirthday(Person person, java.time.LocalDate date){

    }

    @PostMapping("/marry")
    public void getMarried(Person groom, Person bride){

    }
}

