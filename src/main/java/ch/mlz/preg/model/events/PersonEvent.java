package ch.mlz.preg.model.events;

import ch.mlz.preg.PersonHistory;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Objects;

public abstract class PersonEvent {


    //@JsonProperty("id")
    //private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @JsonProperty("creation_time")
    private LocalDateTime creationTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    @JsonProperty("valid_from")
    private LocalDate validFrom;
    @JsonProperty("user")
    private String createdBy;
    @JsonProperty("event_type")
    private PersonEventType type;
    @JsonProperty("person")
    private Long personId;
    @JsonProperty("data")
    private HashMap<String, Object> eventData = new HashMap<>();
    @JsonProperty("history_status")
    private PersonHistory.Status status;

    protected PersonEvent(){}


    protected PersonEvent(PersonEventType type, Long validFor, LocalDate validFrom, LocalDateTime creationTime, String createdBy) {
        this.type = type;
        this.creationTime = creationTime;
        this.createdBy = createdBy;
        this.validFrom = validFrom;
        this.personId = validFor;
        this.status = PersonHistory.Status.APPLICABLE;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public Long getPersonId(){
        return personId;
    }

    public PersonEventType getType() {
        return type;
    }

    protected void putData(String key, Object value){
        eventData.put(key, value);
    }


    public boolean hasData(String key) {
        return eventData.containsKey(key);
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    @JsonIgnore
    public PersonHistory.Status getPersonHistoryStatus() {
        return status;
    }

    @JsonIgnore
    public void setPersonHistoryStatus(PersonHistory.Status status) {
        this.status = status;
    }

    public HashMap<String, Object> getEventData(){
        return eventData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonEvent)) return false;
        PersonEvent that = (PersonEvent) o;
        return Objects.equals(creationTime, that.creationTime) &&
                Objects.equals(validFrom, that.validFrom) &&
                Objects.equals(createdBy, that.createdBy) &&
                type == that.type &&
                Objects.equals(personId, that.personId) &&
                Objects.equals(eventData, that.eventData) &&
                status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(creationTime, validFrom, createdBy, type, personId, eventData, status);
    }
}
