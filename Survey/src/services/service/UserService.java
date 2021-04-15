package services.service;
import enums.PersonRole;
import handlers.IPersonSearch;
import models.Person;
import repositories.UserRepository;
import services.interfaces.IUserService;

import java.util.List;

public class UserService implements IUserService {

    @Override
    public List<Person> findAllUsers() {
        UserRepository rep = new UserRepository();
        return rep.findUsers();
    }
    @Override
    public List<Person> findUsersByRole(PersonRole role) {
        UserRepository rep = new UserRepository();
        return rep.findUsers(new IPersonSearch() {
            @Override
            public boolean existByField(Person person) {
                return person.getRole() == role;
            }
        });
    }
    @Override
    public List<Person> findUsersById(int id) {
        UserRepository rep = new UserRepository();
        return rep.findUsers(new IPersonSearch() {
            @Override
            public boolean existByField(Person person) {
                return person.getId() == id;
            }
        });
    }
    @Override
    public List<Integer> findIdsByRole() {
        return null;
    }
    @Override
    public boolean saveUser(Person person) {
        UserRepository rep = new UserRepository();
        return rep.saveUsers(person);
    }
    @Override
    public boolean removeUser(Person person) {
        UserRepository rep = new UserRepository();
        return rep.removeUsers(person);
    }
    @Override
    public boolean removeUser(int id) {
        UserRepository rep = new UserRepository();
        return rep.removeUsers(findUsersById(id).get(0));
    }
}
