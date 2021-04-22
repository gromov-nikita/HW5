package models;

import enums.PersonRole;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class Person {
    private  String name;
    private Date registrationDate;
    private int id;
    private static int identificator = 0;
    PersonRole role;
    public Person(PersonRole role) {
        registrationDate = new GregorianCalendar().getTime();
        id = ++identificator;
        this.role = role;
    }
    public Date getRegistrationDate() {
        return registrationDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public PersonRole getRole() {
        return role;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name) &&
                role == person.role;
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, id, role);
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", role=" + role +
                '}';
    }
}
