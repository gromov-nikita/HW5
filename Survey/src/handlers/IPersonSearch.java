package handlers;
import models.Person;
public interface IPersonSearch {
    boolean existByField(Person person);
}
