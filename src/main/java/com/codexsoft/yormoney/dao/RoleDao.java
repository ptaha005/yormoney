package com.codexsoft.yormoney.dao;

import com.codexsoft.yormoney.domain.Role;

public interface RoleDao extends DaoInterface<Role> {

    public Role getByRoleName(String name);
}
