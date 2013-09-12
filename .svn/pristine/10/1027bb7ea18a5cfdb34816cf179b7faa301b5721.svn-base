package com.codexsoft.yormoney.security;


        import com.codexsoft.yormoney.domain.Role;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class SigninUtil {
    public static void signin(String username, Role role) {
        List<Role> roles = new ArrayList<Role>();
        roles.add(role);
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null, roles));
    }
}
