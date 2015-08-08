/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestryhibernatedemo.pages;

import com.mycompany.tapestryhibernatedemo.entities.Drzave;
import com.mycompany.tapestryhibernatedemo.entities.Grad;
import com.mycompany.tapestryhibernatedemo.dao.GradDrzaveDao;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author blah
 */
public class GradDrzaveDaoImpl implements GradDrzaveDao 
{
    @Inject
    private Session session;
    
    @Override
    public List<Drzave> getListaSvihDrzava() {
    return session.createCriteria(Drzave.class).list(); 
    }
    
    @Override
    public Drzave getDrzavaById(Integer id) {
    System.out.println("Integer je "+ id);
    return (Drzave) session.createCriteria(Drzave.class).add(Restrictions.eq("id", id)).uniqueResult();
    }
    
    @Override
    public void dodajDrzavu(Drzave drzava) {
    session.persist(drzava); 
    }
   
    @Override
    public void obrisiDrzavu(Integer id) {
    Drzave drzave = (Drzave) session.createCriteria(Drzave.class).add(Restrictions.eq("id", id)).uniqueResult();
    session.delete(drzave);
    }
    
    @Override
    public List<Grad> getListaSvihGradova() {
    return session.createCriteria(Grad.class).list(); 
    }
    
    @Override
    public Grad getGradById(Integer id) {
    return (Grad) session.createCriteria(Grad.class).add(Restrictions.eq("id", id)).uniqueResult(); }
   
    @Override
    public void dodajGrad(Grad grad) {
    session.persist(grad); 
    }
    
    @Override
    public void obrisiGrad(Integer id) {
    Grad grad = (Grad) session.createCriteria(Grad.class).add(Restrictions.eq("id", id)).uniqueResult();
    session.delete(grad); 
    }
}