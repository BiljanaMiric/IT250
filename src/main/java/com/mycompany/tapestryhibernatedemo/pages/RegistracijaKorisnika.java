package com.mycompany.tapestryhibernatedemo.pages;

import com.mycompany.tapestryhibernatedemo.dao.UserDao;
import com.mycompany.tapestryhibernatedemo.data.Role;
import com.mycompany.tapestryhibernatedemo.entities.User;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;

public class RegistracijaKorisnika {
    @Property
    private User userReg; 
    @SessionState
    private User loggedInUser; 
    @Inject
    private UserDao userDao;
    @Component
    private BeanEditForm form;
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
    @CommitAfter
        Object onSuccess() {
            if (!userDao.checkIfEmailExists(userReg.getEmail())) {
                String unhashPassword = userReg.getSifra(); 
                userReg.setSifra(getMD5Hash(unhashPassword)); 
                userReg.setRola(userReg.getRola());
                User u = userDao.registerUser(userReg); 
                loggedInUser = u;
                return Index.class; 
            } else {
                form.recordError("Email koji ste uneli vec postoji");
                return null; 
            }
        } 
}