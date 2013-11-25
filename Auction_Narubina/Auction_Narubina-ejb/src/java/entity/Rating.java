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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Танюся
 */
@Entity
@Table(name = "rating")
@NamedQueries({
    @NamedQuery(name = "Rating.findAll", query = "SELECT r FROM Rating r"),
    @NamedQuery(name = "Rating.findByIDUser", query = "SELECT r FROM Rating r WHERE r.iDUser = :iDUser"),
    @NamedQuery(name = "Rating.findByAmountLots", query = "SELECT r FROM Rating r WHERE r.amountLots = :amountLots"),
    @NamedQuery(name = "Rating.findByAmountLikes", query = "SELECT r FROM Rating r WHERE r.amountLikes = :amountLikes"),
    @NamedQuery(name = "Rating.findByAmountOwnLikes", query = "SELECT r FROM Rating r WHERE r.amountOwnLikes = :amountOwnLikes"),
    @NamedQuery(name = "Rating.findByAmountSales", query = "SELECT r FROM Rating r WHERE r.amountSales = :amountSales"),
    @NamedQuery(name = "Rating.findByMark", query = "SELECT r FROM Rating r WHERE r.mark = :mark")})
public class Rating implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_User")
    private Integer iDUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount_Lots")
    private int amountLots;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount_Likes")
    private int amountLikes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount_Own_Likes")
    private int amountOwnLikes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Amount_Sales")
    private int amountSales;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Mark")
    private int mark;
    @JoinColumn(name = "ID_User", referencedColumnName = "ID_User", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private Users users;

    public Rating() {
    }

    public Rating(Integer iDUser) {
        this.iDUser = iDUser;
    }

    public Rating(Integer iDUser, int amountLots, int amountLikes, int amountOwnLikes, int amountSales, int mark) {
        this.iDUser = iDUser;
        this.amountLots = amountLots;
        this.amountLikes = amountLikes;
        this.amountOwnLikes = amountOwnLikes;
        this.amountSales = amountSales;
        this.mark = mark;
    }

    public Integer getIDUser() {
        return iDUser;
    }

    public void setIDUser(Integer iDUser) {
        this.iDUser = iDUser;
    }

    public int getAmountLots() {
        return amountLots;
    }

    public void setAmountLots(int amountLots) {
        this.amountLots = amountLots;
    }

    public int getAmountLikes() {
        return amountLikes;
    }

    public void setAmountLikes(int amountLikes) {
        this.amountLikes = amountLikes;
    }

    public int getAmountOwnLikes() {
        return amountOwnLikes;
    }

    public void setAmountOwnLikes(int amountOwnLikes) {
        this.amountOwnLikes = amountOwnLikes;
    }

    public int getAmountSales() {
        return amountSales;
    }

    public void setAmountSales(int amountSales) {
        this.amountSales = amountSales;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDUser != null ? iDUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rating)) {
            return false;
        }
        Rating other = (Rating) object;
        if ((this.iDUser == null && other.iDUser != null) || (this.iDUser != null && !this.iDUser.equals(other.iDUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Rating[ iDUser=" + iDUser + " ]";
    }
    
}
