/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Танюся
 */
@Entity
@Table(name = "rate")
@NamedQueries({
    @NamedQuery(name = "Rate.findAll", query = "SELECT r FROM Rate r"),
    @NamedQuery(name = "Rate.findByIDRate", query = "SELECT r FROM Rate r WHERE r.iDRate = :iDRate"),
    @NamedQuery(name = "Rate.findByAmountRate", query = "SELECT r FROM Rate r WHERE r.amountRate = :amountRate"),
    @NamedQuery(name = "Rate.findByDateRate", query = "SELECT r FROM Rate r WHERE r.dateRate = :dateRate")})
public class Rate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Rate")
    private Integer iDRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount_Rate")
    private int amountRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date_Rate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRate;
    @JoinColumn(name = "ID_User", referencedColumnName = "ID_User")
    @ManyToOne(fetch = FetchType.EAGER)
    private Users iDUser;
    @JoinColumn(name = "ID_Lot", referencedColumnName = "ID_Lot")
    @ManyToOne(fetch = FetchType.EAGER)
    private Lot iDLot;

    public Rate() {
    }

    public Rate(Integer iDRate) {
        this.iDRate = iDRate;
    }

    public Rate(Integer iDRate, int amountRate, Date dateRate) {
        this.iDRate = iDRate;
        this.amountRate = amountRate;
        this.dateRate = dateRate;
    }

    public Integer getIDRate() {
        return iDRate;
    }

    public void setIDRate(Integer iDRate) {
        this.iDRate = iDRate;
    }

    public int getAmountRate() {
        return amountRate;
    }

    public void setAmountRate(int amountRate) {
        this.amountRate = amountRate;
    }

    public Date getDateRate() {
        return dateRate;
    }

    public void setDateRate(Date dateRate) {
        this.dateRate = dateRate;
    }

    public Users getIDUser() {
        return iDUser;
    }

    public void setIDUser(Users iDUser) {
        this.iDUser = iDUser;
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
        hash += (iDRate != null ? iDRate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rate)) {
            return false;
        }
        Rate other = (Rate) object;
        if ((this.iDRate == null && other.iDRate != null) || (this.iDRate != null && !this.iDRate.equals(other.iDRate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rate[ iDRate=" + iDRate + " ]";
    }
    
}
