package ch.mlz.preg.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Birth extends PersonEvent {

    public Birth(LocalDateTime createdOn, String createdBy, LocalDate birthday, Person person) {
        super(PersonEventType.BIRTH, person.getId(), birthday.atStartOfDay(), createdOn, createdBy);
    }
}
