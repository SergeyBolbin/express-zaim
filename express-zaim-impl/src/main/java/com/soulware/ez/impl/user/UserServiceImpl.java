package com.soulware.ez.impl.user;

/**
 * User Service implementation
 *
 * Created by bolbin
 * on 01.11.2015.
 */

import com.soulware.ez.model.users.UserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UsersDAO usersDAO;

    public List<UserTO> getAllUsers() {
        return usersDAO.getAllUsers();
    }

    @Transactional(value = Transactional.TxType.NOT_SUPPORTED)
    public UserTO getUserForAuthentification(String login) {
        if(login == null) {
            throw new IllegalArgumentException("Login is not specified");
        }

        return usersDAO.getUserForAuthentification(login);
    }
}
