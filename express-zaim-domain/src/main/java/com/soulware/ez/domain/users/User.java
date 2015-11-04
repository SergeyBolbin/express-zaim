package com.soulware.ez.domain.users;

import javax.persistence.*;
import java.util.List;

/**
 * User domain object
 * Created by bolbin
 * on 28.10.2015.
 */
@Entity
@Table(name = "USER")
@NamedQueries({
    @NamedQuery(name = "getUserForAuthentification",
                query = "SELECT u FROM  User u WHERE u.login=:login AND u.active = true AND u.system = false"),
    @NamedQuery(name = "getAllUsers", query = "SELECT u FROM User u")
})
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "LOGIN", unique = true)
    private String  login;

    @Column(name = "PASSWORD")
    private String  password;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "SYSTEM")
    private Boolean system;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "USER_ROLE",
        joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
        inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}
    )
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public boolean isActive() {
        return active != null ? active : false;
    }

    public boolean isSystem() {
        return system != null ? system : false;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setSystem(Boolean system) {
        this.system = system;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
