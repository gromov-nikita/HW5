package handlers;

import models.Person;

public class PersonSearch implements IPersonSearch {
    @Override
    public boolean existByField(Person person) {
        return person.getRole().equals(person);
    }
}
