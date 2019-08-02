package ch.mlz.preg;

import ch.mlz.preg.model.Address;
import ch.mlz.preg.model.Person;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons/events")
public class EventsController {

    @PostMapping("/birth")
    public void birth(Person father, Person mother, Person child){

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

