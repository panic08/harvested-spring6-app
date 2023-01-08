package ru.alishev.springcourse.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Builder
@Entity
@Table(name = "person", schema = "public")
public class Person {

    @Id
    private int id;

    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 3, max = 10, message = "Name should be min 3 max 10")
    private String name;


    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Person(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
