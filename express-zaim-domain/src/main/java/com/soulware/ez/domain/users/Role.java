package com.soulware.ez.domain.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * User role domain object
 * Created by bolbin
 * on 28.10.2015.
 */
@Entity
@Table(name = "ROLE")
@NamedQueries({
        @NamedQuery(name = "getAllRoles", query = "SELECT r FROM Role r"),
        @NamedQuery(name = "getAllRoleNames", query = "SELECT r.roleName FROM Role r")
})
public class Role {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "ROLE", unique = true)
    private String roleName;

    public Long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
