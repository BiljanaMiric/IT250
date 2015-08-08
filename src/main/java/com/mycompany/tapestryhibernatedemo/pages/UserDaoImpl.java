/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestryhibernatedemo.pages;

import com.mycompany.tapestryhibernatedemo.dao.UserDao;
import com.mycompany.tapestryhibernatedemo.entities.User;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author blah
 */
public class UserDaoImpl implements UserDao {
    
    @Inject
    private Session session;
    
    @Property 
    private User user;
    
    @Override
    public User checkUser(String email, String password) {
    try {
        User u = (User) session.createCriteria(User.class).add(Restrictions.eq("email",
email)).add(Restrictions.eq("sifra", password)).uniqueResult(); 
        if (u != null) {
            return u; }
        return null;
    } 
    catch (NullPointerException e) {
        return null; 
    }
    }
    @Override
    public User registerUser(User user) {
        return (User) session.merge(user); 
    }

    @Override
    public boolean checkIfEmailExists(String email) {
        Long rows = (Long)session.createCriteria(User.class).add(Restrictions.eq("email", email)).setProjection(Projections.rowCount()).uniqueResult();
        return (rows==0) ? false : true; 
    }

}
