package ch.mlz.preg.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ChangeName extends PersonEvent {
    public ChangeName(LocalDateTime createdOn, String createdBy, LocalDate validFrom, Person validFor, String firstName, String lastName) {
        super(PersonEventType.CHANGE_NAME, validFor.getId(), validFrom.atStartOfDay(), createdOn, createdBy);
    }
}
