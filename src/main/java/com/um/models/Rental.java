package com.um.models;

import javax.persistence.*;
// import javax.persistence.Entity;
// import javax.persistence.GenerationType;
// import javax.persistence.GeneratedValue;
// import javax.persistence.Table;
// import javax.persistence.Id;
// import javax.persistence.JoinColumn;
// import javax.persistence.ManyToOne;
// import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "rentals")
public class Rental implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // @Column(name = "client_id")
    // private Integer client_id;

    // @Column(name = "host_id")
    // private Integer host_id;

    // @Column(name = "house_id")
    // private Integer house_id;

    @Column(name = "date")
    private Date date;

    @Column(name = "price")
    private Integer price;

    @ManyToOne
    @JoinColumn(name = "house")
    private House house;

    @ManyToOne
    @JoinColumn(name = "client")
    private User client;

    @ManyToOne
    @JoinColumn(name = "host")
    private User host;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public User getHost() {
        return host;
    }

    public void setHost(User host) {
        this.host = host;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    // public Integer getClientId() {
    //     return client_id;
    // }

    // public void setClientId(Integer client_id) {
    //     this.client_id = client_id;
    // }

    // public Integer getHostId() {
    //     return host_id;
    // }

    // public void setHostId(Integer host_id) {
    //     this.host_id = host_id;
    // }


    // public Integer getHouseId() {
    //     return house_id;
    // }

    // public void setHouseId(Integer house_id) {
    //     this.house_id = house_id;
    // }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}