/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embarcou.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author clovis
 */
@Entity
@Table(name = "pesquisa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pesquisa.findAll", query = "SELECT p FROM Pesquisa p"),
    @NamedQuery(name = "Pesquisa.findAllOrderBy", query = "SELECT p FROM Pesquisa p order by p.id desc"),
    @NamedQuery(name = "Pesquisa.findById", query = "SELECT p FROM Pesquisa p WHERE p.id = :id"),
    @NamedQuery(name = "Pesquisa.findByOrigem", query = "SELECT p FROM Pesquisa p WHERE p.origem = :origem"),
    @NamedQuery(name = "Pesquisa.findByDestino", query = "SELECT p FROM Pesquisa p WHERE p.destino = :destino"),
    @NamedQuery(name = "Pesquisa.findByData", query = "SELECT p FROM Pesquisa p WHERE p.data = :data")})
public class Pesquisa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 32)
    @Column(name = "origem")
    private String origem;
    @Size(max = 32)
    @Column(name = "destino")
    private String destino;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    public Pesquisa() {
    }
    

    public Pesquisa(Integer id) {
        this.id = id;
    }

    public Pesquisa(String origem, String destino, Date data) {
        this.origem = origem;
        this.destino = destino;
        this.data = data;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        if (!(object instanceof Pesquisa)) {
            return false;
        }
        Pesquisa other = (Pesquisa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pesquisa[ id=" + id + " ]";
    }
    
}
