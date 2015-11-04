package com.soulware.ez.web.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.soulware.ez.model.users.RoleTO;
import com.soulware.ez.model.users.UserTO;
import com.soulware.ez.impl.user.UserService;


/**
 * Custom Implementation of Spring Security User Details Service
 * Created by bolbin on 31.10.2015.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    /**
     * {@inheritDoc}
     */
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserTO userTO = userService.getUserForAuthentification(login);
        if(userTO == null) {
            throw new UsernameNotFoundException("User with same login does not exists");
        }

        return buildUserForAuthentication(userTO);
    }

    private UserDetails buildUserForAuthentication(UserTO userTO) {

        List<GrantedAuthority> authorities = buildUserAuthority(userTO.getRoles());
        return new User(userTO.getLogin(),
                userTO.getPassword(),
                userTO.isActive(),
                true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Collection<RoleTO> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        // Build user's authorities
        for (RoleTO userRole : userRoles) {
            setAuths.add(new SimpleGrantedAuthority(userRole.getName()));
        }

        return new ArrayList<GrantedAuthority>(setAuths);
    }
}
