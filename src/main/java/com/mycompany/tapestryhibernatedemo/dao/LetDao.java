/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestryhibernatedemo.dao;

import com.mycompany.tapestryhibernatedemo.entities.Let;
import java.util.List;

/**
 *
 * @author blah
 */
public interface LetDao {
    public List<Let> getListaSvihLetova();
    public Let getLetById(Integer id);
    public void dodajLet(Let let);
    public void obrisiLet(int id);
}
