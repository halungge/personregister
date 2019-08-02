package ch.mlz.preg.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.hamcrest.CoreMatchers;
import static org.hamcrest.CoreMatchers.is;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;



class PersonEventFactoryTest {

    @Test
    public void createBirthEvent(){
        Person person = new Person(123L, "Ali", "Meider", Gender.MALE);
        PersonEvent event = PersonEventFactory.birth(LocalDateTime.now(), "me", LocalDate.of(2018, 7, 23), person);
        assertThat(event.getValidFrom(), is(LocalDateTime.of(2018, 7, 23, 0,0,0)));
        assertThat(event.getType(), is(PersonEventType.BIRTH));
        assertThat(event.getPersonId(), is(123L));
    }

    @Test
    public void createChangeNameEvent(){
        Person person = new Person(144L, "Franz", "Bauer", Gender.MALE);
        final PersonEvent personEvent = PersonEventFactory.changeName(LocalDateTime.now(), "me", LocalDate.of(2018, 3, 3), person, "Franz", "von Assisi");
        assertThat(personEvent.getType(), is(PersonEventType.CHANGE_NAME));
        assertThat(personEvent.getPersonId(), is(144L));
    }

}