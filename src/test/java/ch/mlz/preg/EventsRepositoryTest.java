package ch.mlz.preg;

import ch.mlz.preg.model.Gender;
import ch.mlz.preg.model.Person;
import ch.mlz.preg.model.events.PersonEvent;
import ch.mlz.preg.model.events.PersonEventFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;


class EventsRepositoryTest {
    private EventsRepository repo;
    private Person person;
    private Person hildegard;

    @BeforeEach
    public void setup(){
        person = new Person(99L, "Karl", "Marx", Gender.MALE, LocalDate.of(1879,2,12));
        hildegard = new Person(1L, "Hildegard", "von Bingen", Gender.FEMALE, LocalDate.of(1179,2,12));

        repo = new EventsRepository();
        setupStore();
    }

    @Test
    public void eventHistoryForPerson_ordersEventsByCreation(){
        final List<PersonEvent> events = repo.getEventHistoryForPerson(person);
        assertThat(events.size(), is(3));
        final PersonEvent firstEvent = events.get(0);
        final PersonEvent secondEvent = events.get(1);
        final PersonEvent thirdEvent = events.get(2);
        assertTrue(firstEvent.getCreationTime().isBefore(secondEvent.getCreationTime()));
        assertTrue(secondEvent.getCreationTime().isBefore(thirdEvent.getCreationTime()));

        assertThat(firstEvent.getEventData().get("firstname"), is("Harry"));
        assertThat(firstEvent.getEventData().get("lastname"), is("Potter"));
        assertThat(secondEvent.getEventData().get("firstname"), is("Bilbo"));
        assertThat(secondEvent.getEventData().get("lastname"), is("Beutlin"));
        assertThat(thirdEvent.getEventData().get("firstname"), is("Peter"));
        assertThat(thirdEvent.getEventData().get("lastname"), is("Pan"));
    }

    @Test
    public void personHistory_ordersEventsByValidFrom(){
        final List<PersonEvent> events = repo.getPersonHistoryForPerson(person);
        assertThat(events.size(), is(3));
        final PersonEvent firstEvent = events.get(0);
        final PersonEvent secondEvent = events.get(1);
        final PersonEvent thirdEvent = events.get(2);
        assertTrue(firstEvent.getValidFrom().isBefore(thirdEvent.getValidFrom()));
        assertTrue(secondEvent.getValidFrom().isBefore(thirdEvent.getValidFrom()));
    }


    @Test
    public void personHistory_nonApplicableStateIsRemoved(){
        final List<PersonEvent> historyEvents = repo.getEventHistoryForPerson(hildegard);
        assertThat(historyEvents.size(), is(3));
        assertThat(historyEvents.stream().map(e->e.getPersonHistoryStatus()).filter(s -> PersonHistory.Status.APPLICABLE.equals(s)).count(), is(2L));
        assertThat(historyEvents.stream().map(e->e.getPersonHistoryStatus()).filter(s -> PersonHistory.Status.REMOVED.equals(s)).count(), is(1L));

        final List<PersonEvent> personEvents = repo.getPersonHistoryForPerson(hildegard);
        assertThat(personEvents.size(), is(2));
        assertThat(personEvents.stream().allMatch(s->PersonHistory.Status.APPLICABLE.equals(s.getPersonHistoryStatus())), is(true));


    }


    private void setupStore() {
        LocalDateTime creationDate2019August2 = LocalDateTime.of(2019,8,2,12,23,1);
        LocalDateTime creationDate2019May = LocalDateTime.of(2019,5,23,14,5,6);
        LocalDateTime creationDate2019August1 = LocalDateTime.of(2019,8,2, 11,2,23);
        LocalDate validFrom1970 = LocalDate.of(1970,2,2);
        LocalDate validFrom1988 = LocalDate.of(1988,1,2);
        LocalDate validFrom1999 = LocalDate.of(1999,9,9);

        PersonEvent event1 = PersonEventFactory.changeName(creationDate2019August2, "me", validFrom1970, person, "Peter", "Pan" );
        repo.save(event1);
        PersonEvent event2 = PersonEventFactory.changeName(creationDate2019May, "you", validFrom1988, person, "Harry", "Potter" );
        repo.save(event2);
        PersonEvent event3 = PersonEventFactory.changeName(creationDate2019August1, "other", validFrom1999, person, "Bilbo", "Beutlin" );
        repo.save(event3);

        PersonEvent event11 = PersonEventFactory.changeName(creationDate2019August2, "me", validFrom1970, hildegard, "Klara", "Schumann" );
        repo.save(event11);
        PersonEvent event12 = PersonEventFactory.changeName(creationDate2019May, "you", validFrom1988, hildegard, "Madonna", "" );
        event12.setPersonHistoryStatus(PersonHistory.Status.REMOVED);
        repo.save(event12);
        PersonEvent event13 = PersonEventFactory.changeName(creationDate2019August1, "other", validFrom1999, hildegard, "Annebäbi", "Jowäger" );
        repo.save(event13);

    }

}