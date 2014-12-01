package com.alankehoe.app.model;

import java.util.Objects;
import java.util.UUID;

/**
 * Created by alan on 10/10/2014.
 */

public class User {

    private UUID id;
    private String firstName;
    private String lastName;
    private int age;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return Objects.equals(this.id, other.id) && Objects.equals(this.firstName, other.firstName) && Objects.equals(this.lastName, other.lastName) && Objects.equals(this.age, other.age);
    }
}
