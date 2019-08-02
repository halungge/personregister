package ch.mlz.preg.model;

import java.time.LocalDateTime;

public abstract class PersonEvent {
    private LocalDateTime creationTime;
    private LocalDateTime validFrom;
    private String createdBy;
    private PersonEventType type;
    private Long personId;

    protected PersonEvent(PersonEventType type, Long validFor, LocalDateTime validFrom, LocalDateTime creationTime, String createdBy) {
        this.type = type;
        this.creationTime = creationTime;
        this.createdBy = createdBy;
        this.validFrom = validFrom;
        this.personId = validFor;
    }
    public LocalDateTime getValidFrom() {
        return validFrom;
    }

    public Long getPersonId(){
        return personId;
    }

    public PersonEventType getType() {
        return type;
    }


}
