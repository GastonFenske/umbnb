package com.um.umbnb.entity;

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

    @Column
    private Integer clients_id;

    @Column
    private Integer hosts_id;

    @Column
    private String houses_id;

    @Column
    private Date date;

    @Column
    private Integer price;

    @ManyToOne
    @JoinColumn
    private House house;

    @ManyToOne
    @JoinColumn
    private User user;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public Integer getClientsId() {
        return clients_id;
    }

    public void setClientsId(Integer clients_id) {
        this.clients_id = clients_id;
    }

    public Integer getHostsId() {
        return hosts_id;
    }

    public void setHostsId(Integer hosts_id) {
        this.hosts_id = hosts_id;
    }


    public String getHousesId() {
        return houses_id;
    }

    public void setHousesId(String houses_id) {
        this.houses_id = houses_id;
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
