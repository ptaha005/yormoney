package com.codexsoft.yormoney.security;

import com.codexsoft.yormoney.domain.User;
import com.codexsoft.yormoney.services.UserService;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;


public class UsernameAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Autowired
    private UserService userService;

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
        String username = String.valueOf(auth.getName());
        String pswd = String.valueOf(auth.getCredentials());

        logger.info("Trying authenticate user with username authentication username = " + username);
        User user = checkAuthorization(username, pswd);

        return createSuccessAuthentication(user.getUsername(), authentication, user);
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        return userService.findByUsername(username);
    }

    private User checkAuthorization(String username, String pass) {
        if (username == null) {
            logger.info("REST:AUTHORIZATION-CHECK: Username is not specified");
            throw new BadCredentialsException("Username is empty");
        }
        User u = userService.findByUsername(username);
        if (u == null) {
            logger.info("REST:AUTHORIZATION-CHECK: User not found");
        } else if (pass == null) {
            logger.info("REST:AUTHORIZATION-CHECK: Password nor Token are not specified");
            throw new BadCredentialsException("Password is empty");
        } else {
            pass = StringEscapeUtils.unescapeHtml(pass);
            PasswordEncoder encoder = new Md5PasswordEncoder();
            pass = encoder.encodePassword(pass, null);
            if (u.getPassword().equals(pass)) {
                logger.info("REST:AUTHORIZATION-CHECK: Success");
                return u;
            } else {
                logger.info("REST:AUTHORIZATION-CHECK: Failure");
            }
        }
        throw new BadCredentialsException("Bad Credentials");
    }
}
