package com.codexsoft.yormoney.dao.impl;

import com.codexsoft.yormoney.dao.MemberDao;
import com.codexsoft.yormoney.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDaoImpl extends HibernateDao<Member> implements MemberDao {
    public MemberDaoImpl(){
        super(Member.class);
    }
}
