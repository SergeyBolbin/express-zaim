package com.soulware.ez.impl.converter;

import com.soulware.ez.domain.users.Role;
import com.soulware.ez.domain.users.User;
import com.soulware.ez.model.users.RoleTO;
import com.soulware.ez.model.users.UserTO;

/**
 * User converter. Converts Users Entities to UserTO objects
 * Created by bolbin on 31.10.2015.
 */
public class UserConverter extends AbstractConverter<User, UserTO>{

    /**
     * Convert User to UserTO object
     * @param user user to convert
     * @return new instance of UserTO corresponds User
     */
    @Override
    public UserTO convertEntity(User user) {
        UserTO userTO = new UserTO( user.getId(),
                                    user.getLogin(),
                                    user.getPassword(),
                                    user.isActive(),
                                    user.isSystem() );

        for(Role r : user.getRoles()) {
            userTO.getRoles().add(new RoleTO(r.getId(), r.getRoleName()));
        }
        return userTO;
    }
}
