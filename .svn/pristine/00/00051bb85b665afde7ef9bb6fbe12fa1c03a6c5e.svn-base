package com.codexsoft.yormoney.services;

import com.codexsoft.yormoney.dao.FamilyDao;
import com.codexsoft.yormoney.dao.MemberDao;
import com.codexsoft.yormoney.domain.Family;
import com.codexsoft.yormoney.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private FamilyDao familyDao;


    @Transactional
    public Member getMemberById(Long id){
        return memberDao.read(id);
    }

    @Transactional
    public void saveOrUpdateFamily(Family family){
        familyDao.saveOrUpdate(family);
    }

    @Transactional
    public void saveOrUpdateMember(Member member){
        memberDao.saveOrUpdate(member);
    }

    @Transactional
    public List<Member> getMemberCollectionByParams(Map<String, Object> param){
        return memberDao.getListByParams(param);
    }

    @Transactional
    public void deleteMember(Member member){
        memberDao.delete(member);
    }
}
