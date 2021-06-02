/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "etud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etud.findAll", query = "SELECT e FROM Etud e")
    , @NamedQuery(name = "Etud.findById", query = "SELECT e FROM Etud e WHERE e.id = :id")
    , @NamedQuery(name = "Etud.findByNom", query = "SELECT e FROM Etud e WHERE e.nom = :nom")
    , @NamedQuery(name = "Etud.findByPrenom", query = "SELECT e FROM Etud e WHERE e.prenom = :prenom")
    , @NamedQuery(name = "Etud.findByNote", query = "SELECT e FROM Etud e WHERE e.note = :note")})
public class Etud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "nom")
    private String nom;
    @Size(max = 30)
    @Column(name = "prenom")
    private String prenom;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "note")
    private Double note;

    public Etud() {
    }

    public Etud(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Double getNote() {
        return note;
    }

    public void setNote(Double note) {
        this.note = note;
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
        if (!(object instanceof Etud)) {
            return false;
        }
        Etud other = (Etud) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.Etud[ id=" + id + " ]";
    }
    
}
