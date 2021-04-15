import enums.PersonRole;
import handlers.IPersonSearch;
import models.Admin;
import models.Manager;
import models.Person;
import models.Worker;
import repositories.UserRepository;
import services.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        UserRepository rep = new UserRepository();
        UserService service = new UserService();
        rep.saveUsers(new Admin("Nick"));
        rep.saveUsers(new Manager("Illa"));
        rep.saveUsers(new Worker("Sasha"));
        rep.saveUsers(new Admin("Lisa"));
        System.out.println(service.findAllUsers());
        System.out.println(service.findUsersById(2));
        System.out.println(service.findUsersByRole(PersonRole.ADMIN));
        rep.sortByField("name");
        System.out.println(service.findAllUsers());
        rep.sortByField("id");
        System.out.println(service.findAllUsers());
    }
}