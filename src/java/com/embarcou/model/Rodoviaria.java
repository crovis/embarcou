/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embarcou.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author clovis
 */
@Entity
@Table(name = "rodoviaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rodoviaria.findAll", query = "SELECT r FROM Rodoviaria r"),
    @NamedQuery(name = "Rodoviaria.findById", query = "SELECT r FROM Rodoviaria r WHERE r.id = :id"),
    @NamedQuery(name = "Rodoviaria.findByNome", query = "SELECT r FROM Rodoviaria r WHERE r.nome = :nome")})
public class Rodoviaria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 2147483647)
    @Column(name = "nome")
    private String nome;
    @OneToMany(mappedBy = "rodoviariaDestino")
    private Collection<Trecho> trechoCollection;
    @OneToMany(mappedBy = "rodoviariaOrigem")
    private Collection<Trecho> trechoCollection1;

    public Rodoviaria() {
    }

    public Rodoviaria(Integer id) {
        this.id = id;
    }
    
    public Rodoviaria(String nome){
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @XmlTransient
    public Collection<Trecho> getTrechoCollection() {
        return trechoCollection;
    }

    public void setTrechoCollection(Collection<Trecho> trechoCollection) {
        this.trechoCollection = trechoCollection;
    }

    @XmlTransient
    public Collection<Trecho> getTrechoCollection1() {
        return trechoCollection1;
    }

    public void setTrechoCollection1(Collection<Trecho> trechoCollection1) {
        this.trechoCollection1 = trechoCollection1;
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
        if (!(object instanceof Rodoviaria)) {
            return false;
        }
        Rodoviaria other = (Rodoviaria) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Rodoviaria[ id=" + id + " ]";
    }
    
}
