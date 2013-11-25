/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Танюся
 */
@Entity
@Table(name = "lot")
@NamedQueries({
    @NamedQuery(name = "Lot.findAll", query = "SELECT l FROM Lot l"),
    @NamedQuery(name = "Lot.findByIDLot", query = "SELECT l FROM Lot l WHERE l.iDLot = :iDLot"),
    @NamedQuery(name = "Lot.findByNameLot", query = "SELECT l FROM Lot l WHERE l.nameLot = :nameLot"),
    @NamedQuery(name = "Lot.findByStartCost", query = "SELECT l FROM Lot l WHERE l.startCost = :startCost"),
    @NamedQuery(name = "Lot.findByAddedDate", query = "SELECT l FROM Lot l WHERE l.addedDate = :addedDate"),
    @NamedQuery(name = "Lot.findByMinRate", query = "SELECT l FROM Lot l WHERE l.minRate = :minRate"),
    @NamedQuery(name = "Lot.findByTradingHours", query = "SELECT l FROM Lot l WHERE l.tradingHours = :tradingHours")})
public class Lot implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Lot")
    private Integer iDLot;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name_Lot")
    private String nameLot;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Start_Cost")
    private int startCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Added_Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Min_Rate")
    private int minRate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Trading_Hours")
    private int tradingHours;
    @OneToMany(mappedBy = "iDLot", cascade = CascadeType.ALL)
    private List<Rate> rateList;     
    @JoinColumn(name = "ID_Category", referencedColumnName = "ID_Category")
    @ManyToOne(fetch = FetchType.EAGER)
    private Category iDCategory;
    @JoinColumn(name = "ID_User", referencedColumnName = "ID_User")
    @ManyToOne(fetch = FetchType.EAGER)
    private Users iDUser;
    @OneToMany(mappedBy = "iDLot", fetch = FetchType.EAGER)
    private List<Comments> commentsList;

    public Lot() {
    }

    public Lot(Integer iDLot) {
        this.iDLot = iDLot;
    }

    public Lot(Integer iDLot, String nameLot, String description, int startCost, Date addedDate, int minRate, int tradingHours) {
        this.iDLot = iDLot;
        this.nameLot = nameLot;
        this.description = description;
        this.startCost = startCost;
        this.addedDate = addedDate;
        this.minRate = minRate;
        this.tradingHours = tradingHours;
    }
    
    public Integer getIDLot() {
        return iDLot;
    }

    public void setIDLot(Integer iDLot) {
        this.iDLot = iDLot;
    }

    public String getNameLot() {
        return nameLot;
    }

    public void setNameLot(String nameLot) {
        this.nameLot = nameLot;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStartCost() {
        return startCost;
    }

    public void setStartCost(int startCost) {
        this.startCost = startCost;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public int getMinRate() {
        return minRate;
    }

    public void setMinRate(int minRate) {
        this.minRate = minRate;
    }

    public int getTradingHours() {
        return tradingHours;
    }

    public void setTradingHours(int tradingHours) {
        this.tradingHours = tradingHours;
    }
    @XmlTransient
    public List<Rate> getRateList() {
        return rateList;
    }

    public void setRateList(List<Rate> rateList) {
        this.rateList = rateList;
    }

    public Category getIDCategory() {
        return iDCategory;
    }

    public void setIDCategory(Category iDCategory) {
        this.iDCategory = iDCategory;
    }

    public Users getIDUser() {
        return iDUser;
    }

    public void setIDUser(Users iDUser) {
        this.iDUser = iDUser;
    }
     @XmlTransient
    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDLot != null ? iDLot.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lot)) {
            return false;
        }
        Lot other = (Lot) object;
        if ((this.iDLot == null && other.iDLot != null) || (this.iDLot != null && !this.iDLot.equals(other.iDLot))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Lot[ iDLot=" + iDLot + " ]";
    }
    
}
