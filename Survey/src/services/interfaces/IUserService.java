package services.interfaces;

import enums.PersonRole;
import models.Person;

import java.util.List;

public interface IUserService {
    List<Person> findAllUsers();
    List<Person> findUsersByRole(PersonRole role);
    List<Person> findUsersById(int id);
    List<Integer> findIdsByRole();
    boolean saveUser(Person person);
    boolean removeUser(Person person);
    boolean removeUser(int id);
}
