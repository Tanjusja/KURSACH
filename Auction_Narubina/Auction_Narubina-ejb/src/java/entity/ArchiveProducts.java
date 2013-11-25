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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Танюся
 */
@Entity
@Table(name = "archive_products")
@NamedQueries({
    @NamedQuery(name = "ArchiveProducts.findAll", query = "SELECT a FROM ArchiveProducts a"),
    @NamedQuery(name = "ArchiveProducts.findByIDProduct", query = "SELECT a FROM ArchiveProducts a WHERE a.iDProduct = :iDProduct"),
    @NamedQuery(name = "ArchiveProducts.findByNameLot", query = "SELECT a FROM ArchiveProducts a WHERE a.nameLot = :nameLot"),
    @NamedQuery(name = "ArchiveProducts.findByStartCost", query = "SELECT a FROM ArchiveProducts a WHERE a.startCost = :startCost"),
    @NamedQuery(name = "ArchiveProducts.findByAddedDate", query = "SELECT a FROM ArchiveProducts a WHERE a.addedDate = :addedDate"),
    @NamedQuery(name = "ArchiveProducts.findByLastDateRate", query = "SELECT a FROM ArchiveProducts a WHERE a.lastDateRate = :lastDateRate"),
    @NamedQuery(name = "ArchiveProducts.findByBuyedOfUser", query = "SELECT a FROM ArchiveProducts a WHERE a.buyedOfUser = :buyedOfUser")})
public class ArchiveProducts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Product")
    private Integer iDProduct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name_Lot")
    private String nameLot;
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
    @Column(name = "Last_Date_Rate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastDateRate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Buyed_Of_User")
    private String buyedOfUser;
    @JoinColumn(name = "ID_User", referencedColumnName = "ID_User")
    @ManyToOne(fetch = FetchType.EAGER)
    private Users iDUser;

    public ArchiveProducts() {
    }

    public ArchiveProducts(Integer iDProduct) {
        this.iDProduct = iDProduct;
    }

    public ArchiveProducts(Integer iDProduct, String nameLot, int startCost, Date addedDate, Date lastDateRate, String buyedOfUser) {
        this.iDProduct = iDProduct;
        this.nameLot = nameLot;
        this.startCost = startCost;
        this.addedDate = addedDate;
        this.lastDateRate = lastDateRate;
        this.buyedOfUser = buyedOfUser;
    }

    public Integer getIDProduct() {
        return iDProduct;
    }

    public void setIDProduct(Integer iDProduct) {
        this.iDProduct = iDProduct;
    }

    public String getNameLot() {
        return nameLot;
    }

    public void setNameLot(String nameLot) {
        this.nameLot = nameLot;
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

    public Date getLastDateRate() {
        return lastDateRate;
    }

    public void setLastDateRate(Date lastDateRate) {
        this.lastDateRate = lastDateRate;
    }

    public String getBuyedOfUser() {
        return buyedOfUser;
    }

    public void setBuyedOfUser(String buyedOfUser) {
        this.buyedOfUser = buyedOfUser;
    }

    public Users getIDUser() {
        return iDUser;
    }

    public void setIDUser(Users iDUser) {
        this.iDUser = iDUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDProduct != null ? iDProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ArchiveProducts)) {
            return false;
        }
        ArchiveProducts other = (ArchiveProducts) object;
        if ((this.iDProduct == null && other.iDProduct != null) || (this.iDProduct != null && !this.iDProduct.equals(other.iDProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ArchiveProducts[ iDProduct=" + iDProduct + " ]";
    }
    
}
