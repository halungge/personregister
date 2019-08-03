package ch.mlz.preg.model.events;

import ch.mlz.preg.model.Person;

import java.time.LocalDate;
import java.time.LocalDateTime;



public class PersonEventFactory {
   public static PersonEvent birth(LocalDateTime createdOn, String createdBy, LocalDate birthday, Person person){
       return new Birth(createdOn, createdBy, birthday, person);
   }


    public static PersonEvent changeName(LocalDateTime createdOn, String createdBy, LocalDate validFrom, Person validFor, String firstName, String lastName) {
        return new ChangeName(createdOn, createdBy, validFrom, validFor, firstName, lastName);
   }
}
