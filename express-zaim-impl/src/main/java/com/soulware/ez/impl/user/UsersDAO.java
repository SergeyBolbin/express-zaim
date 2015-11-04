package com.soulware.ez.impl.user;

import com.soulware.ez.model.users.UserTO;

import java.util.List;

/**
 * Users Data Access Object
 * Created by bolbin on 31.10.2015.
 */
public interface UsersDAO {

    /**
     * Get User by login
     * @param login user login
     * @return userTO if user was found, null otherwise
     */
    UserTO getUserForAuthentification(String login);

    /**
     * Fetches all users list
     * @return list of all users
     */
    List<UserTO> getAllUsers();
}
