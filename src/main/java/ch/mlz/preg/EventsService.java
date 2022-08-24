package ch.mlz.preg;

import ch.mlz.preg.model.events.PersonEvent;

public class EventsService {
    private EventsRepository eventStore;

    public EventsService(EventsRepository eventStore) {
        this.eventStore = eventStore;
    }


    public boolean save(PersonEvent event){
        eventStore.save(event);
        return true;
    }

}
