/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestryhibernatedemo.dao;

import com.mycompany.tapestryhibernatedemo.entities.Avion;
import java.util.List;

/**
 *
 * @author blah
 */
public interface AvionDao {
    public List<Avion> getListaSvihAviona();
    public Avion getAvionById(Integer id);
    public void dodajAvion(Avion avion);

    public void obrisiAvion(int id);
}
