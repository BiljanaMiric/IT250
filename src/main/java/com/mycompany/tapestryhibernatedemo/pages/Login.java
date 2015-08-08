/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestryhibernatedemo.pages;

import com.mycompany.tapestryhibernatedemo.dao.UserDao;
import com.mycompany.tapestryhibernatedemo.entities.User;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author blah
 */
public class Login { 
    @Inject
    private UserDao userDao; 
    @Property
    private User userLogin; 
    @SessionState
    private User loggedInUser; 
    @Component
    private BeanEditForm form;
    Object onActivate() {
        if (loggedInUser.getEmail() != null) {
            return Index.class;
        } 
    return null; 
    }
    public String getMD5Hash(String yourString) { 
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(yourString.getBytes()); 
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3)); 
            }
            return sb.toString(); 
        } 
        catch (Exception e) {
            return ""; 
        }
    }
    Object onSuccess() {
        String password = getMD5Hash(userLogin.getSifra()); 
        System.out.println(password);
        User u = userDao.checkUser(userLogin.getEmail(), password); 
        if (u!=null) {
            loggedInUser = u; System.out.println("Logovan"); 
            return Index.class;
        } 
        else {
            form.recordError("Uneli ste pogrešne parametre"); 
            System.out.println("losi parametri");
            return null;
        } 
    }
}