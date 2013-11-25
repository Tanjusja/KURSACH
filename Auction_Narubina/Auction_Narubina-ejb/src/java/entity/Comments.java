/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Танюся
 */
@Entity
@Table(name = "comments")
@NamedQueries({
    @NamedQuery(name = "Comments.findAll", query = "SELECT c FROM Comments c"),
    @NamedQuery(name = "Comments.findByIDComments", query = "SELECT c FROM Comments c WHERE c.iDComments = :iDComments"),
    @NamedQuery(name = "Comments.findByDescription", query = "SELECT c FROM Comments c WHERE c.description = :description")})
public class Comments implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Comments")
    private Integer iDComments;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Description")
    private String description;
    @JoinColumn(name = "ID_Lot", referencedColumnName = "ID_Lot")
    @ManyToOne(fetch = FetchType.EAGER)
    private Lot iDLot;

    public Comments() {
    }

    public Comments(Integer iDComments) {
        this.iDComments = iDComments;
    }

    public Comments(Integer iDComments, String description) {
        this.iDComments = iDComments;
        this.description = description;
    }

    public Integer getIDComments() {
        return iDComments;
    }

    public void setIDComments(Integer iDComments) {
        this.iDComments = iDComments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Lot getIDLot() {
        return iDLot;
    }

    public void setIDLot(Lot iDLot) {
        this.iDLot = iDLot;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDComments != null ? iDComments.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comments)) {
            return false;
        }
        Comments other = (Comments) object;
        if ((this.iDComments == null && other.iDComments != null) || (this.iDComments != null && !this.iDComments.equals(other.iDComments))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Comments[ iDComments=" + iDComments + " ]";
    }
    
}
