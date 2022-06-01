package com.um.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class House implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private Integer rooms_number;

    @Column
    private Integer persons_number;

    @Column
    private Integer review;

    @Column
    private Boolean type;

    @Column
    private Integer price;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRoomsNumber() {
        return rooms_number;
    }

    public void setRoomsNumber(Integer rooms_number) {
        this.rooms_number = rooms_number;
    }

    public Integer getPersonsNumber() {
        return persons_number;
    }

    public void setPersonsNumber(Integer persons_number) {
        this.persons_number = persons_number;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
