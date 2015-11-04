package com.soulware.ez.impl.user;

import com.soulware.ez.model.users.UserTO;

import java.util.List;

/**
 * Provides functionality for user management
 *
 * Created by bolbin
 * on 01.11.2015.
 */
public interface UserService {

    /**
     * Return list of users
     * @return list of users
     */
    List<UserTO> getAllUsers();

    /**
     * Return user for authentification
     * @param login login
     * @return User for authentification
     */
    UserTO getUserForAuthentification(String login);

}
