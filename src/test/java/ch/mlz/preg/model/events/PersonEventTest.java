package ch.mlz.preg.model.events;

import ch.mlz.preg.model.Gender;
import ch.mlz.preg.model.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


class PersonEventTest {

    @Test
    public void testChangeNameEvent(){
        Person validFor = new Person(1L,"D", "M", Gender.MALE, LocalDate.of(2002,2,2) );
        final PersonEvent event = PersonEventFactory.changeName(LocalDateTime.now(), "me", LocalDate.of(
                2008, 3, 3), validFor, "Draco", "Malfoy");
        assertThat(event.getType(), is(PersonEventType.CHANGE_NAME));
        assertThat(event.hasData("firstname"), is(true));
        assertThat(event.hasData("lastname"), is(true));

    }

}