/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestryhibernatedemo.data;

import org.apache.tapestry5.ioc.annotations.Inject;



/**
 *
 * @author blah
 */
public class Avion {
    private String proizvodjac;
    private String model;
    private String godinaProizvodnje;
    private String brojMesta;
    
    @Inject
    public Avion () {}
        public Avion (String Proizvodjac, String Model, String godinaProizvodnje, 
                String brojMesta) {
            this.proizvodjac=Proizvodjac;
            this.model=Model;
            this.godinaProizvodnje=godinaProizvodnje;
            this.brojMesta=brojMesta;
        }
        
        public String getProizvodjac (){
            return proizvodjac;
        }
        public void setProizvodjac(String Proizvodjac){
            this.proizvodjac=Proizvodjac;
            
        }
        public String getModel(){
            return model;
        }
        public void setModel (String Model){
        this.model=Model;
    }
        public String getgodinaProizvodnje(){
            return godinaProizvodnje;
        }
        public void setgodinaProizvodnje (String godinaProizvodnje) {
                this.godinaProizvodnje=godinaProizvodnje;
        }
        public String getbrojMesta (){
            return brojMesta;
        }
        public void setbrojMestra (String brojMesta) {
            this.brojMesta=brojMesta;
        }
      
}
