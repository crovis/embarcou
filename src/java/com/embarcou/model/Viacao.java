/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embarcou.model;

import java.io.Serializable;
import java.math.BigInteger;
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
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author clovis
 */
@Entity
@Table(name = "viacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Viacao.findAll", query = "SELECT v FROM Viacao v"),
    @NamedQuery(name = "Viacao.findById", query = "SELECT v FROM Viacao v WHERE v.id = :id"),
    @NamedQuery(name = "Viacao.findByCnpj", query = "SELECT v FROM Viacao v WHERE v.cnpj = :cnpj"),
    @NamedQuery(name = "Viacao.findByNome", query = "SELECT v FROM Viacao v WHERE v.nome = :nome"),
    @NamedQuery(name = "Viacao.findByTelefone", query = "SELECT v FROM Viacao v WHERE v.telefone = :telefone"),
    @NamedQuery(name = "Viacao.findBySite", query = "SELECT v FROM Viacao v WHERE v.site = :site"),
    @NamedQuery(name = "Viacao.findByLogo", query = "SELECT v FROM Viacao v WHERE v.logo = :logo")})
public class Viacao implements Serializable {
    @Column(name = "cnpj")
    private String cnpj;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 64)
    @Column(name = "nome")
    private String nome;
    @Column(name = "telefone")
    private String telefone;
    @Size(max = 64)
    @Column(name = "site")
    private String site;
    @Size(max = 64)
    @Column(name = "logo")
    private String logo;
    @OneToMany(mappedBy = "viacao")
    private Collection<Trecho> trechoCollection;

    public Viacao() {
    }

    public Viacao(Integer id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @XmlTransient
    public Collection<Trecho> getTrechoCollection() {
        return trechoCollection;
    }

    public void setTrechoCollection(Collection<Trecho> trechoCollection) {
        this.trechoCollection = trechoCollection;
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
        if (!(object instanceof Viacao)) {
            return false;
        }
        Viacao other = (Viacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Viacao[ id=" + id + " ]";
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
}
