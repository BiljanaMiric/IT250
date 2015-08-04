package com.mycompany.tapestryhibernatedemo.pages;


import com.mycompany.tapestryhibernatedemo.entities.Avion;
import java.util.ArrayList;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;


public class DodavanjeAviona {
    @Property
    private Avion avion;
    @Inject
    private Session session;
    @Property
    private ArrayList<Avion> avioni;
    void onActivate() {
        if (avioni == null) {
            avioni = new ArrayList<Avion>();
        }
// createCriteria metoda pravi Select * upit nad prosleđenom klasom 
        avioni = (ArrayList<Avion>) session.createCriteria(Avion.class).list();
}
    @CommitAfter
    Object onSuccess() {
        // persist metoda čuva objekatu bazi podataka
        session.persist(avion);
        return this;
}
}