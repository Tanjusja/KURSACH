package entity;

import entity.Lot;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-26T03:26:37")
@StaticMetamodel(Comments.class)
public class Comments_ { 

    public static volatile SingularAttribute<Comments, Integer> iDComments;
    public static volatile SingularAttribute<Comments, String> description;
    public static volatile SingularAttribute<Comments, Lot> iDLot;

}