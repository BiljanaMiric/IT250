/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestryhibernatedemo.pages;

import com.mycompany.tapestryhibernatedemo.dao.AvionDao;
import com.mycompany.tapestryhibernatedemo.entities.Avion;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author blah
 */
public class AvionDaoImpl implements AvionDao {
    @Inject
    private Session session;
    @Override
    public List<Avion> getListaSvihAviona() {
    return session.createCriteria(Avion.class).list(); }
    @Override
    public Avion getAvionById(Integer id) {
    return (Avion) session.createCriteria(Avion.class).add(Restrictions.eq("id",id)).uniqueResult(); }
    @Override
    public void dodajAvion(Avion avion) {
    session.persist(avion); 
    }
    @Override
    public void obrisiAvion(int id){
        Avion avion=(Avion)
                session.createCriteria(Avion.class).add(Restrictions.eq("id",id)).uniqueResult();
        session.delete(avion);
    }
}
