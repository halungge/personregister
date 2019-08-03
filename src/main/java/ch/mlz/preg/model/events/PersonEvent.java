package ch.mlz.preg.model.events;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;

public abstract class PersonEvent {
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

    protected PersonEvent(){}


    protected PersonEvent(PersonEventType type, Long validFor, LocalDate validFrom, LocalDateTime creationTime, String createdBy) {
        this.type = type;
        this.creationTime = creationTime;
        this.createdBy = createdBy;
        this.validFrom = validFrom;
        this.personId = validFor;
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
}
