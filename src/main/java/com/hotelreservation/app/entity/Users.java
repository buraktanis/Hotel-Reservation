package com.hotelreservation.app.entity;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

public class Users {

    private Integer id;
    private String name;
    private String surname;

    public Users() {
        // Varsayılan kurucu
    }

    @JsonCreator
    public Users(@JsonProperty("id") Integer id, @JsonProperty("name") String name, @JsonProperty("surname") String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


}
