package ch.mlz.preg.model.events;

import ch.mlz.preg.model.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ChangeName extends PersonEvent {


    public ChangeName(LocalDateTime createdOn, String createdBy, LocalDate validFrom, Person validFor, String firstName, String lastName) {
        super(PersonEventType.CHANGE_NAME, validFor.getId(), validFrom, createdOn, createdBy);
        setLastName(lastName);
        setFirstName(firstName);
    }

    private ChangeName() {
        super();
    }

    private void setFirstName(String firstName) {
        putData("firstname", firstName);
    }

    private void setLastName(String lastName) {
        putData("lastname", lastName);
    }

}
