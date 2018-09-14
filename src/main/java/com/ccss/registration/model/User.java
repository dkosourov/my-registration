package com.ccss.registration.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Collection;

@Entity
@Table(name = "user", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {

    @Id
    @SequenceGenerator(name = "seq-gen", sequenceName = "MY_SEQ_GEN", initialValue = 205, allocationSize = 12)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq-gen")
    @Column(name = "id")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public User() {
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String email, String password, Collection<Role> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long pId) {
        id = pId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String pEmail) {
        email = pEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String pPassword) {
        password = pPassword;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> pRoles) {
        roles = pRoles;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", email='" + email + '\'' + ", password='" + "*********" + '\'' + ", roles="
                + roles + '}';
    }
}