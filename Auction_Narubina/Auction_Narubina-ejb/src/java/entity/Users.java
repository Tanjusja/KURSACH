/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author Танюся
 */
@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByIDUser", query = "SELECT u FROM Users u WHERE u.iDUser = :iDUser"),
    @NamedQuery(name = "Users.findByFio", query = "SELECT u FROM Users u WHERE u.fio = :fio"),
    @NamedQuery(name = "Users.findByLogin", query = "SELECT u FROM Users u WHERE u.login = :login"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByPhoneNumber", query = "SELECT u FROM Users u WHERE u.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Users.findByISAdmin", query = "SELECT u FROM Users u WHERE u.iSAdmin = :iSAdmin")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_User")
    private Integer iDUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "FIO")
    private String fio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Login")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Phone_Number")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IS_Admin")
    private boolean iSAdmin;
    @OneToMany(mappedBy = "iDUser", fetch = FetchType.EAGER)
    private List<Rate> rateList;
    @OneToMany(mappedBy = "iDUser", fetch = FetchType.EAGER)
    private List<ArchiveProducts> archiveProductsList;
    @OneToMany(mappedBy = "iDUser", fetch = FetchType.EAGER)
    private List<Lot> lotList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "users", fetch = FetchType.EAGER)
    private Rating rating;

    public Users() {
    }

    public Users(Integer iDUser) {
        this.iDUser = iDUser;
    }

    public Users(Integer iDUser, String fio, String login, String password, String phoneNumber, boolean iSAdmin) {
        this.iDUser = iDUser;
        this.fio = fio;
        this.login = login;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.iSAdmin = iSAdmin;
    }

    public Integer getIDUser() {
        return iDUser;
    }

    public void setIDUser(Integer iDUser) {
        this.iDUser = iDUser;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getISAdmin() {
        return iSAdmin;
    }

    public void setISAdmin(boolean iSAdmin) {
        this.iSAdmin = iSAdmin;
    }
    @XmlTransient
    public List<Rate> getRateList() {
        return rateList;
    }

    public void setRateList(List<Rate> rateList) {
        this.rateList = rateList;
    }
    @XmlTransient
    public List<ArchiveProducts> getArchiveProductsList() {
        return archiveProductsList;
    }

    public void setArchiveProductsList(List<ArchiveProducts> archiveProductsList) {
        this.archiveProductsList = archiveProductsList;
    }
    @XmlTransient
    public List<Lot> getLotList() {
        return lotList;
    }

    public void setLotList(List<Lot> lotList) {
        this.lotList = lotList;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.iDUser == null && other.iDUser != null) || (this.iDUser != null && !this.iDUser.equals(other.iDUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Users[ iDUser=" + iDUser + " ]";
    }
    
}
