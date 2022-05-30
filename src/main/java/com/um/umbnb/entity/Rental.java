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
    private String clients_name;

    @Column
    private String clients_mail;

    @Column
    private Integer clients_id;

    @Column
    private String hosts_name;

    @Column
    private String hosts_mail;

    @Column
    private Integer hosts_id;

    @Column
    private String houses_name;

    @Column
    private String houses_id;

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

    public String getClientsName() {
        return clients_name;
    }

    public void setClientsName(String clients_name) {
        this.clients_name = clients_name;
    }

    public String getClientsMail() {
        return clients_mail;
    }

    public void setClientsMail(String clients_mail) {
        this.clients_mail = clients_mail;
    }

    public Integer getClientsId() {
        return clients_id;
    }

    public void setClientsId(Integer clients_id) {
        this.clients_id = clients_id;
    }

    public String getHostsName() {
        return hosts_name;
    }

    public void setHostsName(String hosts_name) {
        this.hosts_name = hosts_name;
    }

    public String getHostsMail() {
        return hosts_mail;
    }

    public void setHostsMail(String hosts_mail) {
        this.hosts_mail = hosts_mail;
    }

    public Integer getHostsId() {
        return hosts_id;
    }

    public void setHostsId(Integer hosts_id) {
        this.hosts_id = hosts_id;
    }

    public String getHousesName() {
        return houses_name;
    }

    public void setHousesName(String houses_name) {
        this.houses_name = houses_name;
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
