/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "category")
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByIDCategory", query = "SELECT c FROM Category c WHERE c.iDCategory = :iDCategory"),
    @NamedQuery(name = "Category.findByNameCategory", query = "SELECT c FROM Category c WHERE c.nameCategory = :nameCategory")})
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_Category")
    private Integer iDCategory;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Name_Category")
    private String nameCategory;
    @OneToMany(mappedBy = "iDCategory")
    private List<Lot> lotList;

    public Category() {
    }

    public Category(Integer iDCategory) {
        this.iDCategory = iDCategory;
    }

    public Category(Integer iDCategory, String nameCategory) {
        this.iDCategory = iDCategory;
        this.nameCategory = nameCategory;
    }

    public Integer getIDCategory() {
        return iDCategory;
    }

    public void setIDCategory(Integer iDCategory) {
        this.iDCategory = iDCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
     @XmlTransient
    public List<Lot> getLotList() {
        return lotList;
    }

    public void setLotList(List<Lot> lotList) {
        this.lotList = lotList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iDCategory != null ? iDCategory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.iDCategory == null && other.iDCategory != null) || (this.iDCategory != null && !this.iDCategory.equals(other.iDCategory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Category[ iDCategory=" + iDCategory + " ]";
    }
    
}
