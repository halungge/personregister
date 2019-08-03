package ch.mlz.preg.model.events;

import ch.mlz.preg.model.Gender;
import ch.mlz.preg.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class PersonEventSerializerTest {

    private PersonEventSerializer mapper;
    private String nameChangeAsJson;

    @BeforeEach
    public void setup(){
        mapper = new PersonEventSerializer();
        nameChangeAsJson = "{\"creation_time\":\"2019-08-02T12:12:12\",\"valid_from\":\"2000-02-02\",\"user\":\"Harry\",\"event_type\":\"CHANGE_NAME\",\"person\":23,\"data\":" +
                "{\"firstname\":\"Hermione\",\"lastname\":\"Granger\"}}";
    }

    @Test
    public void serializeChangeNameEvent() throws JsonProcessingException {
        final LocalDate birthday = LocalDate.of(2000, 2, 2);
        Person person = new Person(23L, "Grundig","Herberta", Gender.FEMALE, birthday);
        LocalDateTime createdOn = LocalDateTime.of(2019, 8,2, 12,12,12);
        final PersonEvent personEvent = PersonEventFactory.changeName(createdOn, "Harry", birthday, person, "Hermione", "Granger");

        final String result = mapper.serialize(personEvent);

        assertThat(result, is(this.nameChangeAsJson));
    }


    @Test
    public void deserializeChangeNameEvent() throws IOException {
        final PersonEvent event = mapper.parseFromString(nameChangeAsJson);
        assertThat(event.getType(), is(PersonEventType.CHANGE_NAME));
        assertThat(event.hasData("firstname"), is(true));
        assertThat(event.hasData("lastname"), is(true));
    }


}