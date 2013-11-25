package entity;

import entity.Lot;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-26T03:26:37")
@StaticMetamodel(Category.class)
public class Category_ { 

    public static volatile ListAttribute<Category, Lot> lotList;
    public static volatile SingularAttribute<Category, String> nameCategory;
    public static volatile SingularAttribute<Category, Integer> iDCategory;

}