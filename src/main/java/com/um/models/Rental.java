package com.um.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Rental implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn
    private House house_id;

    @ManyToOne
    @JoinColumn
    private User client_id;

    @ManyToOne
    @JoinColumn
    private User host_id;

    @Column
    private Date date;

    @Column
    private Integer price;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public House getHouseId() {
        return house_id;
    }

    public void setHouseId(House house_id) {
        this.house_id = house_id;
    }

    public User getClientId() {
        return client_id;
    }

    public void setClientId(User client_id) {
        this.client_id = client_id;
    }

    public User getHostId() {
        return host_id;
    }

    public void setHostId(User host_id) {
        this.host_id = host_id;
    }

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
