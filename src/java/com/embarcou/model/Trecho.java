/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.embarcou.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author clovis
 */
@Entity
@Table(name = "trecho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trecho.findAll", query = "SELECT t FROM Trecho t"),
    @NamedQuery(name = "Trecho.findById", query = "SELECT t FROM Trecho t WHERE t.id = :id"),
    @NamedQuery(name = "Trecho.findByDomingo", query = "SELECT t FROM Trecho t WHERE t.domingo = :domingo"),
    @NamedQuery(name = "Trecho.findBySegunda", query = "SELECT t FROM Trecho t WHERE t.segunda = :segunda"),
    @NamedQuery(name = "Trecho.findByTerca", query = "SELECT t FROM Trecho t WHERE t.terca = :terca"),
    @NamedQuery(name = "Trecho.findByQuarta", query = "SELECT t FROM Trecho t WHERE t.quarta = :quarta"),
    @NamedQuery(name = "Trecho.findByQuinta", query = "SELECT t FROM Trecho t WHERE t.quinta = :quinta"),
    @NamedQuery(name = "Trecho.findBySexta", query = "SELECT t FROM Trecho t WHERE t.sexta = :sexta"),
    @NamedQuery(name = "Trecho.findBySabado", query = "SELECT t FROM Trecho t WHERE t.sabado = :sabado"),
    @NamedQuery(name = "Trecho.findBySaida", query = "SELECT t FROM Trecho t WHERE t.saida = :saida"),
    @NamedQuery(name = "Trecho.findByChegada", query = "SELECT t FROM Trecho t WHERE t.chegada = :chegada"),
    @NamedQuery(name = "Trecho.findByPreco", query = "SELECT t FROM Trecho t WHERE t.preco = :preco"),
    @NamedQuery(name = "Trecho.findByOrigemDestinoDomingo", query = "SELECT t FROM Trecho t  WHERE t.rodoviariaOrigem.nome = :origem AND t.rodoviariaDestino.nome = :destino AND t.domingo=1 ORDER BY t.preco ASC"),
    @NamedQuery(name = "Trecho.findByOrigemDestinoSegunda", query = "SELECT t FROM Trecho t  WHERE t.rodoviariaOrigem.nome = :origem AND t.rodoviariaDestino.nome = :destino AND t.segunda=1 ORDER BY t.preco ASC"),
    @NamedQuery(name = "Trecho.findByOrigemDestinoTerca", query = "SELECT t FROM Trecho t  WHERE t.rodoviariaOrigem.nome = :origem AND t.rodoviariaDestino.nome = :destino AND t.terca=1 ORDER BY t.preco ASC"),
    @NamedQuery(name = "Trecho.findByOrigemDestinoQuarta", query = "SELECT t FROM Trecho t  WHERE t.rodoviariaOrigem.nome = :origem AND t.rodoviariaDestino.nome = :destino AND t.quarta=1 ORDER BY t.preco ASC"),
    @NamedQuery(name = "Trecho.findByOrigemDestinoQuinta", query = "SELECT t FROM Trecho t  WHERE t.rodoviariaOrigem.nome = :origem AND t.rodoviariaDestino.nome = :destino AND t.quinta=1 ORDER BY t.preco ASC"),
    @NamedQuery(name = "Trecho.findByOrigemDestinoSexta", query = "SELECT t FROM Trecho t  WHERE t.rodoviariaOrigem.nome = :origem AND t.rodoviariaDestino.nome = :destino AND t.sexta=1 ORDER BY t.preco ASC"),
    @NamedQuery(name = "Trecho.findByOrigemDestinoSabado", query = "SELECT t FROM Trecho t  WHERE t.rodoviariaOrigem.nome = :origem AND t.rodoviariaDestino.nome = :destino AND t.sabado=1 ORDER BY t.preco ASC"),
    //@NamedQuery(name = "Trecho.findByOrigemDestino", query = "SELECT t FROM Trecho t  WHERE t.rodoviariaOrigem.nome = :origem AND t.rodoviariaDestino.nome = :destino"),
})

public class Trecho implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "domingo")
    private Integer domingo;
    @Column(name = "segunda")
    private Integer segunda;
    @Column(name = "terca")
    private Integer terca;
    @Column(name = "quarta")
    private Integer quarta;
    @Column(name = "quinta")
    private Integer quinta;
    @Column(name = "sexta")
    private Integer sexta;
    @Column(name = "sabado")
    private Integer sabado;
    @Column(name = "saida")
    private String saida;
    @Column(name = "chegada")
    private String chegada;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "preco")
    private Float preco;
    @JoinColumn(name = "viacao", referencedColumnName = "id")
    @ManyToOne
    private Viacao viacao;
    @JoinColumn(name = "rodoviaria_destino", referencedColumnName = "id")
    @ManyToOne
    private Rodoviaria rodoviariaDestino;
    @JoinColumn(name = "rodoviaria_origem", referencedColumnName = "id")
    @ManyToOne
    private Rodoviaria rodoviariaOrigem;

    public Trecho() {
    }

    public Trecho(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDomingo() {
        return domingo;
    }

    public void setDomingo(Integer domingo) {
        this.domingo = domingo;
    }

    public Integer getSegunda() {
        return segunda;
    }

    public void setSegunda(Integer segunda) {
        this.segunda = segunda;
    }

    public Integer getTerca() {
        return terca;
    }

    public void setTerca(Integer terca) {
        this.terca = terca;
    }

    public Integer getQuarta() {
        return quarta;
    }

    public void setQuarta(Integer quarta) {
        this.quarta = quarta;
    }

    public Integer getQuinta() {
        return quinta;
    }

    public void setQuinta(Integer quinta) {
        this.quinta = quinta;
    }

    public Integer getSexta() {
        return sexta;
    }

    public void setSexta(Integer sexta) {
        this.sexta = sexta;
    }

    public Integer getSabado() {
        return sabado;
    }

    public void setSabado(Integer sabado) {
        this.sabado = sabado;
    }

    public String getSaida() {
        return saida;
    }

    public void setSaida(String saida) {
        this.saida = saida;
    }

    public String getChegada() {
        return chegada;
    }

    public void setChegada(String chegada) {
        this.chegada = chegada;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Viacao getViacao() {
        return viacao;
    }

    public void setViacao(Viacao viacao) {
        this.viacao = viacao;
    }

    public Rodoviaria getRodoviariaDestino() {
        return rodoviariaDestino;
    }

    public void setRodoviariaDestino(Rodoviaria rodoviariaDestino) {
        this.rodoviariaDestino = rodoviariaDestino;
    }

    public Rodoviaria getRodoviariaOrigem() {
        return rodoviariaOrigem;
    }

    public void setRodoviariaOrigem(Rodoviaria rodoviariaOrigem) {
        this.rodoviariaOrigem = rodoviariaOrigem;
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
        if (!(object instanceof Trecho)) {
            return false;
        }
        Trecho other = (Trecho) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.embarcou.model.Trecho[ id=" + id + " ]";
    }
    
}
