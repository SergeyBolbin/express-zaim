package com.soulware.ez.impl.user;

import com.soulware.ez.domain.users.Role;
import com.soulware.ez.domain.users.User;
import com.soulware.ez.impl.converter.UserConverter;
import com.soulware.ez.model.users.UserTO;

import java.util.List;

import org.springframework.stereotype.Repository;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


/**
 * Users DAO implementation
 * Created by bolbin on 31.10.2015.
 */
@Repository
public class UsersDAOImpl implements UsersDAO {

    @PersistenceContext(unitName = "ExpressZaimPersistence")
    EntityManager entityManager;

    /**
     * {@inheritDoc}
     */
    public UserTO getUserForAuthentification(String login) {
        TypedQuery<User> query = entityManager.createNamedQuery("getUserForAuthentification", User.class).
                                               setParameter("login", login);

        UserTO result = null;
        List<User> usersList = query.getResultList();
        if(!usersList.isEmpty()) {
            result = new UserConverter().convertEntity(usersList.get(0));
        }

        return result;
    }

    /**
     * {@inheritDoc}
     */
    public List<UserTO> getAllUsers() {
        TypedQuery<User> query = entityManager.createNamedQuery("getAllUsers", User.class);
        return  new UserConverter().convertEntityList(query.getResultList());

    }
}
