/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestryhibernatedemo.pages;

import com.mycompany.tapestryhibernatedemo.entities.Drzave;
import com.mycompany.tapestryhibernatedemo.entities.Grad;
import com.mycompany.tapestryhibernatedemo.dao.GradDrzaveDao;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author blah
 */
public class DodavanjeGradova { 
    @Property
    private Grad grad;
    @Property
    private Grad onegrad; 
    @Inject
    private Messages messages; 
    @Inject
    private GradDrzaveDao drzaveDao; 
    @Property
    private Drzave drzId;
    @Property
    @Persist
    private List<Drzave> drzave; 
    
    public ValueEncoder getEncoder(){
   
        return new ValueEncoder<Drzave>() {
        @Override
        public String toClient(Drzave v) {
            return String.valueOf(v.getId()); 
        }
        
        @Override
        public Drzave toValue(String string) {
            Drzave drz = drzaveDao.getDrzavaById(Integer.parseInt(string));
            return drz; }
        }; 
    }
        
    @Property
    private List<Grad> gradovi; 
    void onActivate() {
        grad = new Grad(); 
        if (gradovi == null) {
            gradovi = new ArrayList<Grad>();
        }
        gradovi = drzaveDao.getListaSvihGradova(); 
        drzave = drzaveDao.getListaSvihDrzava();
        }
        @CommitAfter Object onSuccess() {
            grad.setDrzId(drzId); 
            drzaveDao.dodajGrad(grad); 
            return this;
        }
        
        public String getDrzava(){
            if (onegrad.getDrzId()!=null){
                return onegrad.getDrzId().getImeDrzave();
            } else {
                return "";
            }
        }
        
        @CommitAfter
        Object onActionFromDelete(int id) 
        {
            drzaveDao.obrisiGrad(id);
            return this; 
        }
       }