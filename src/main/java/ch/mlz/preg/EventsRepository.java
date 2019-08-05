package ch.mlz.preg;

import ch.mlz.preg.model.Person;
import ch.mlz.preg.model.events.PersonEvent;

import java.util.*;
import java.util.stream.Collectors;

//TODO add tests
public class EventsRepository {
    private HashMap<Long, List<PersonEvent>> store= new HashMap<>();

    public void save(PersonEvent event) {
        if(store.containsKey(event.getPersonId())){
            store.get(event.getPersonId()).add(event);
        }else{
            List<PersonEvent> newList = new ArrayList<PersonEvent>();
            newList.add(event);
            store.put(event.getPersonId(), newList);
        }
    }
    
    public List<PersonEvent> getEventHistoryForPerson(Person p){
        final java.util.List<PersonEvent> personEvents = getPersonEvents(p);
        Comparator<PersonEvent> creationComparator = new Comparator<PersonEvent>() {
            @Override
            public int compare(PersonEvent event1, PersonEvent event2) {
                return event1.getCreationTime().compareTo(event2.getCreationTime());
            }
        };
        Collections.sort(personEvents, creationComparator);
        return personEvents;
    }

    private List<PersonEvent> getPersonEvents(Person p) {
        return store.get(p.getId());
    }

    public List<PersonEvent>  getPersonHistoryForPerson(Person p){
        final List<PersonEvent> applicableEvents = getPersonEvents(p).stream().filter(e ->
                PersonHistory.Status.APPLICABLE.equals(e.getPersonHistoryStatus())).collect(Collectors.toList());
        Comparator<PersonEvent> validFromComparator = new Comparator<PersonEvent>() {
            @Override
            public int compare(PersonEvent event1, PersonEvent event2) {
                return event1.getValidFrom().compareTo(event2.getValidFrom());
            }
        };
        Collections.sort(applicableEvents, validFromComparator);
        return applicableEvents;
    }


}
