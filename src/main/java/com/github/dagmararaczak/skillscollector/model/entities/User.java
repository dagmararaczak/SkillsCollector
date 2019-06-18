package com.github.dagmararaczak.skillscollector.model.entities;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_known_sources", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "source_id"))
    Set<Source> knownSources = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_unknown_sources", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "source_id"))
    Set<Source> unknownSources = new HashSet<>();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(nullable = false)
    private String password;
    @Column(unique = true,nullable = false)
    private String username;

    public Long getId() {
        return id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Source> getKnownSources() {
        return knownSources;
    }

    public void setKnownSources(Set<Source> knownSources) {
        this.knownSources = knownSources;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }

    public Set<Source> getUnknownSources() {
        return unknownSources;
    }

    public void setUnknownSources(Set<Source> unknownSources) {
        this.unknownSources = unknownSources;
    }
}

