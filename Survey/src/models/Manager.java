package models;

import enums.PersonRole;

public class Manager extends Person {
    public Manager(PersonRole role) {
        super(role);
    }
    public Manager(String name) {
        super(PersonRole.MANAGER);
        this.setName(name);
    }
}
