package models;

import enums.PersonRole;

public class Admin extends Person {
    private Admin(PersonRole role) {
        super(role);

    }
    public Admin(String name) {
        super(PersonRole.ADMIN);
        this.setName(name);
    }
}
