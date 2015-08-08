/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestryhibernatedemo.dao;

import com.mycompany.tapestryhibernatedemo.entities.Drzave;
import com.mycompany.tapestryhibernatedemo.entities.Grad;
import java.util.List;

/**
 *
 * @author blah
 */
public interface GradDrzaveDao
{
    public List<Drzave> getListaSvihDrzava();
    public Drzave getDrzavaById(Integer id);
    public void dodajDrzavu(Drzave drzava);
    public void obrisiDrzavu(Integer id);
    public List<Grad> getListaSvihGradova();
    public Grad getGradById(Integer id);
    public void dodajGrad(Grad grad);
    public void obrisiGrad(Integer id); 
}