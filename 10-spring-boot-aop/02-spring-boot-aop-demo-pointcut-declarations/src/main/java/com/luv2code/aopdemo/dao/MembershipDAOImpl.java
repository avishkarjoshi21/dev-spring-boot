package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO {

    @Override
    public boolean addSilliyMember() {
        System.out.println(getClass() + " : DOING MY DB WORK: ADDING MEMBERSHIP ACCOUNT TO DB");
        return true;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + " : I'm going to sleep");
    }
}
