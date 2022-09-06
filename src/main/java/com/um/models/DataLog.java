package com.um.models;

public class DataLog {

    private String access_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    private Long id;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public DataLog(String token, Long id) {
        this.setAccess_token(token);
        this.setId(id);
    }
}