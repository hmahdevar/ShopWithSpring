package com.hossein.kesens.model.access;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hossein on 4/12/17.
 */

@Entity
public class Authorities implements Serializable{

    private static final long serialVersionUID = -6708154998146742569L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authoritiesId;
    private String email;
    private String authority;
    @OneToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private Users user;

    public Authorities() {
    }

    public Authorities(String email, String authority, Users user) {
        this.email = email;
        this.authority = authority;
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public int getAuthoritiesId() {
        return authoritiesId;
    }

    public void setAuthoritiesId(int authoritiesId) {
        this.authoritiesId = authoritiesId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
