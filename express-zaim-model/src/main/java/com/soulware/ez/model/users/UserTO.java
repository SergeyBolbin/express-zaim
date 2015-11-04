package com.soulware.ez.model.users;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Transfer Object for Application User Presentation
 * Created by bolbin on 31.10.2015.
 */
public class UserTO  implements Serializable {

    private static final long serialVersionUID = 3923142298727641451L;

    private Long id;
    private String login;
    private String password;
    private boolean active;
    private boolean system;
    private List<RoleTO> roles = new ArrayList<RoleTO>();

    public UserTO() {
    }

    public UserTO(Long id,
                  String login,
                  String password,
                  boolean active,
                  boolean system) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.active = active;
        this.system = system;
    }

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
        return active;
    }

    public boolean isSystem() {
        return system;
    }

    public List<RoleTO> getRoles() {
        return roles;
    }
}