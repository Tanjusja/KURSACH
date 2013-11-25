package entity;

import entity.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-26T03:26:37")
@StaticMetamodel(ArchiveProducts.class)
public class ArchiveProducts_ { 

    public static volatile SingularAttribute<ArchiveProducts, Date> addedDate;
    public static volatile SingularAttribute<ArchiveProducts, String> buyedOfUser;
    public static volatile SingularAttribute<ArchiveProducts, Date> lastDateRate;
    public static volatile SingularAttribute<ArchiveProducts, Integer> iDProduct;
    public static volatile SingularAttribute<ArchiveProducts, Integer> startCost;
    public static volatile SingularAttribute<ArchiveProducts, String> nameLot;
    public static volatile SingularAttribute<ArchiveProducts, Users> iDUser;

}