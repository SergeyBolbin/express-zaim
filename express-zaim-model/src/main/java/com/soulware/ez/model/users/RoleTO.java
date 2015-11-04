package com.soulware.ez.model.users;

import java.io.Serializable;

/**
 * App User Role Transfer Object
 * Created by bolbin on 31.10.2015.
 */
public class RoleTO implements Serializable {

    private static final long serialVersionUID = 2798050988476100056L;

    private Long id;
    private String name;

    public RoleTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
