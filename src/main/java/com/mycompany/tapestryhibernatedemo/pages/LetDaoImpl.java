/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestryhibernatedemo.pages;

import com.mycompany.tapestryhibernatedemo.dao.LetDao;
import com.mycompany.tapestryhibernatedemo.entities.Let;
import java.util.List;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author blah
 */
public class LetDaoImpl implements LetDao {
    @Inject
    private Session session;
    @Override
    public List<Let> getListaSvihLetova() {
    return session.createCriteria(Let.class).list(); 
    }
    @Override
    public Let getLetById(Integer id) {
    return (Let) session.createCriteria(Let.class).add(Restrictions.eq("id",id)).uniqueResult(); 
    }
    @Override
    public void dodajLet(Let let) {
    session.persist(let); 
    }
    @Override
    public void obrisiLet(int id){
        Let let=(Let)
                session.createCriteria(Let.class).add(Restrictions.eq("id",id)).uniqueResult();
        session.delete(let);
    }
}
