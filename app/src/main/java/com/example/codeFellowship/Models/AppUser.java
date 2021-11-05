package com.example.codeFellowship.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String blodType;
    private String authority;
    private String placeName;
    private String emailAdress;
    private String phoneNum;


    @OneToMany(mappedBy = "appUser")
    private List<Post> posts;

    @ManyToMany
    @JoinTable(
            name="user_followers",
            joinColumns = { @JoinColumn(name = "primaryUser") },
            inverseJoinColumns = { @JoinColumn(name = "followedUser") }
    )
    public List<AppUser> followers;

    @ManyToMany(mappedBy = "followers")
    public List<AppUser> usersFollowedBy;
    public AppUser(){}

    public AppUser(String username, String password, String firstName, String lastName, String dateOfBirth, String blodType,String authority, String placeName, String emailAdress, String phoneNum) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.blodType = blodType;
        this.authority=authority;
        this.placeName=placeName;
        this.emailAdress=emailAdress;
        this.phoneNum=phoneNum;

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority=new SimpleGrantedAuthority(authority);
        List<SimpleGrantedAuthority> grantedAuthorities=new ArrayList<SimpleGrantedAuthority>();
        grantedAuthorities.add(simpleGrantedAuthority);
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void addFollower(AppUser follower) {
        this.followers.add(follower);
    }

    public void removeFollower(AppUser follower) {
        this.followers.remove(follower);
    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public String getblodType() {
        return blodType;
    }

    public void setblodType(String blodType) {
        this.blodType = blodType;
    }


    public String getplaceName() {
        return placeName;
    }

    public void setplaceName(String placeName) {
        this.placeName = placeName;
    }




    public String getemailAdress() {
        return emailAdress;
    }

    public void setemailAdress(String emailAdress) {
        this.emailAdress=emailAdress;
    }


    public String getphoneNum() {
        return phoneNum;
    }

    public void setphoneNum(String phoneNum) {
        this.phoneNum=phoneNum;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}