package ch.mlz.preg.model.events;

import ch.mlz.preg.model.Gender;
import ch.mlz.preg.model.Person;
import ch.mlz.preg.model.events.PersonEvent;
import ch.mlz.preg.model.events.PersonEventFactory;
import ch.mlz.preg.model.events.PersonEventType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;



class PersonEventFactoryTest {

    @Test
    public void createBirthEvent(){
        final LocalDate birthday = LocalDate.of(2018, 7, 23);
        Person person = new Person(123L, "Ali", "Meider", Gender.MALE, birthday );
        PersonEvent event = PersonEventFactory.birth(LocalDateTime.now(), "me", birthday, person);
        assertThat(event.getValidFrom(), is(birthday));
        assertThat(event.getType(), is(PersonEventType.BIRTH));
        assertThat(event.getPersonId(), is(123L));
    }

    @Test
    public void createChangeNameEvent(){
        Person person = new Person(144L, "Franz", "Bauer", Gender.MALE, LocalDate.of(2017,2,2) );
        final PersonEvent personEvent = PersonEventFactory.changeName(LocalDateTime.now(), "me", LocalDate.of(2018, 3, 3), person, "Franz", "von Assisi");
        assertThat(personEvent.getType(), is(PersonEventType.CHANGE_NAME));
        assertThat(personEvent.getPersonId(), is(144L));
    }

}