package org.example.Entity;

import io.swagger.v3.oas.annotations.media.Schema;


@Schema(name="Rooms", description = "Author Entity")

public class Rooms {

    private Integer id;

    private Integer how_many_person;
    private Integer price;
    @Schema(description="Name of room", example = "Orhan")

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHow_many_person() {
        return how_many_person;
    }

    public void setHow_many_person(Integer how_many_person) {
        this.how_many_person = how_many_person;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
