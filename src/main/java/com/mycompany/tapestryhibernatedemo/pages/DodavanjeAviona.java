package com.mycompany.tapestryhibernatedemo.pages;


import com.mycompany.tapestryhibernatedemo.dao.AvionDao;
import com.mycompany.tapestryhibernatedemo.entities.Avion;
import java.util.ArrayList;
import java.util.List;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;


public class DodavanjeAviona {
    @Property
    private Avion avion;
    @Property
    private Avion oneavion;
    @Inject
    private AvionDao avionDao;
    
    @Property 
    private List<Avion> avioni;
    
    void onActivate() {
        if (avioni == null) {
            avioni = new ArrayList<Avion>();
        }

        avioni = avionDao.getListaSvihAviona();
    }
    
    @CommitAfter
    Object onSuccess() {
        avionDao.dodajAvion(avion);
        return this;
    } 
    @CommitAfter
    Object onActionFromDelete(int id)
    {
        avionDao.obrisiAvion(id);
        return this;
    }
}
