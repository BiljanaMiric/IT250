package com.mycompany.tapestryhibernatedemo.pages;


import com.mycompany.tapestryhibernatedemo.dao.LetDao;
import com.mycompany.tapestryhibernatedemo.entities.Let;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;


public class DodavanjeLetova {
    @Property
    private Let let;
    @Property
    private Let onelet;
    @Inject
    private LetDao letDao;
    
    @Property 
    private List<Let> letovi;
    
    void onActivate() {
        if (letovi == null) {
            letovi = new ArrayList<Let>();
        }

        letovi = letDao.getListaSvihLetova();
    }
    
    @CommitAfter
    Object onSuccess() {
        letDao.dodajLet(let);
        return this;
    } 
    @CommitAfter
    Object onActionFromDelete(int id)
    {
        letDao.obrisiLet(id);
        return this;
    }
}
