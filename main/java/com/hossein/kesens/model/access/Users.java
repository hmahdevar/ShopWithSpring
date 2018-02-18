package com.hossein.kesens.model.access;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by hossein on 4/11/17.
 */
@Entity
public class Users implements Serializable {


    private static final long serialVersionUID = 7936243774019433327L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String email;
    private String password;
    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "authoritiesId")
    @JsonIgnore
    private Authorities authorities;
    public Users() {
        this.authorities = new Authorities();
        authorities.setUser(this);
    }

    public Users(String email, String password, boolean enabled , String authority) {
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.authorities = new Authorities(email,authority,this);
    }

    public Authorities getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Authorities authorities) {
        this.authorities = authorities;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        authorities.setEmail(email);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority(){
        return authorities.getAuthority();
    }
    public void setAuthority(String authority){
        authorities.setAuthority(authority);
    }
}
