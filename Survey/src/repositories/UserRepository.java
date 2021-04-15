package repositories;
import enums.PersonRole;
import handlers.IPersonSearch;
import models.Person;

import java.awt.*;
import java.lang.reflect.Field;
import java.util.*;
import java.util.List;

public class UserRepository {
    private static List<Person> persons = new ArrayList<>();
    public List<Person> findUsers() {
        return persons;
    }
    public boolean saveUsers(Person person) {
        if(person == null) {
            return false;
        }
        if(person.getName() == null || person.getName().isEmpty()) {
            throw new IllegalArgumentException("Name not found");
        }
        persons.add(person);
        return true;
    }
    public boolean removeUsers(Person person) {
        if(person == null) {
            return false;
        }
        persons.remove(person);
        return true;
    }
    public List<Person> findUsers(IPersonSearch searchResponse) {
        List<Person> filteredPersons = new LinkedList<>();
        for(Person person : persons) {
            if(searchResponse.existByField(person)) {
                filteredPersons.add(person);
            }
        }
        return filteredPersons;
    }
    public void sortByField(String fieldName) {
        switch (fieldName) {
            case "name" : {
                Collections.sort(persons, new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });
                break;
            }
            case "id" : {
                Collections.sort(persons, new Comparator<Person>() {
                    @Override
                    public int compare(Person o1, Person o2) {
                        return o1.getId() - o2.getId();
                    }
                });
                break;
            }
        }
    }
}
