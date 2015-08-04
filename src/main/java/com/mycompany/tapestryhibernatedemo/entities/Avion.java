/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tapestryhibernatedemo.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.apache.tapestry5.beaneditor.Validate;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author blah
 */
@Entity
@Table(name = "AVION")
@NamedQueries({
    @NamedQuery(name = "Avion.findAll", query = "SELECT a FROM Avion a")})
public class Avion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PROIZVODJAC")
    private String proizvodjac;
    @Basic(optional = false)
    @Validate("required, minLength=5")
    @Column(name = "MODEL")
    private String model;
    @Column(name = "GODINA_PROIZVODNJE")
    private Integer godinaProizvodnje;
    @Basic(optional = false)
    @Column(name = "BROJ_MESTA")
    private int brojMesta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aviId")
    private List<Let> letList;
    
    @Inject
    public Avion() {
    }

    public Avion(Integer id) {
        this.id = id;
    }

    public Avion(Integer id, String Proizvodjac, String Model, int brojMesta) {
        this.id = id;
        this.proizvodjac = Proizvodjac;
        this.model = Model;
        this.brojMesta = brojMesta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public void setProizvodjac(String Proizvodjac) {
        this.proizvodjac = Proizvodjac;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String Model) {
        this.model = Model;
    }

    public Integer getGodinaProizvodnje() {
        return godinaProizvodnje;
    }

    public void setGodinaProizvodnje(Integer godinaProizvodnje) {
        this.godinaProizvodnje = godinaProizvodnje;
    }

    public int getBrojMesta() {
        return brojMesta;
    }

    public void setBrojMesta(int brojMesta) {
        this.brojMesta = brojMesta;
    }

    public List<Let> getLetList() {
        return letList;
    }

    public void setLetList(List<Let> letList) {
        this.letList = letList;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avion)) {
            return false;
        }
        Avion other = (Avion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.tapestryhibernatedemo.entities.Avion[ id=" + id + " ]";
    }
    
}
