package ch.mlz.preg.model.events;

import ch.mlz.preg.model.Person;
import ch.mlz.preg.model.events.PersonEvent;
import ch.mlz.preg.model.events.PersonEventType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Birth extends PersonEvent {

    public Birth(LocalDateTime createdOn, String createdBy, LocalDate birthday, Person person) {
        super(PersonEventType.BIRTH, person.getId(), birthday, createdOn, createdBy);
    }
}
