package com.example.codeFellowship.Models;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Collection;

@Entity
public class Hospital implements UserDetails {
    @javax.persistence.Id
    @Column(name = "idn", nullable = false)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String placeName;
    private String password;



    public Hospital() {
    }

    public Hospital(String userName, String placeName,String password) {
        this.userName = userName;
        this.placeName = placeName;
        this.password=password;
    }

    public Integer getId() {
        return id;
    }


    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getPlaceName() {
        return placeName;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}