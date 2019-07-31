# personregister

## Datenmodell
Person properties
 * name
 * firstname
 * address
   * street
   * nr
   * place
   * zipcode
 *birthday
 *family
   * other persons with certain relations
     * mother
     * father
     * sibling
   * gender
## Events
* CREATE_PERSON -> returns a Person
* BIRTH -> returns a Person with a relation to at least one other person (mother)
* MOVE -> Person has a new address
* DEATH -> Person is dead after event, cannot move anymore
* CHANGE_NAME
* MARRY
* CHANGE_BIRTHDAY

each event has 
* an event date (=when was the event registered)
* an author (by whom was the event done)
* a valid from date = (birthday in case of BIRTH and CREATE_PERSON and CHANGE_BIRTHDAY, wedding day in case of MARRY, moving day in case of MOVE, death day in case of DEATH, validity date of the change in case of CHANGE_NAME)
* a couple of fields changed in the event, those value are valid on the Person from the valid from date
* MOVE can be done for all persons at the same address, which will register an event on each of these persons.
