package com.um.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import java.io.Serializable;

// @Data
@Entity
@Table(name = "houses")
public class House implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ManyToOne
    @JoinColumn(name = "owner")
    private User owner;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "rooms_number")
    private String rooms_number;

    @Column(name = "persons_number")
    private String persons_number;

    @Column(name = "review")
    private Integer review;

    @Column(name = "price")
    private Integer price;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return address;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public String getRoomsNumber() {
        return rooms_number;
    }

    public void setRoomsNumber(String rooms_number) {
        this.rooms_number = rooms_number;
    }

    public String getPersonsNumber() {
        return persons_number;
    }

    public void setPersonNumber(String persons_number) {
        this.persons_number = persons_number;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public Integer getPrecio() {
        return price;
    }

    public void setPrecio(Integer price) {
        this.price = price;
    }


}
