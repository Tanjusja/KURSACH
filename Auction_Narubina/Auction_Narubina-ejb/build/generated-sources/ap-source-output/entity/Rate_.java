package entity;

import entity.Lot;
import entity.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-26T03:26:37")
@StaticMetamodel(Rate.class)
public class Rate_ { 

    public static volatile SingularAttribute<Rate, Integer> iDRate;
    public static volatile SingularAttribute<Rate, Users> iDUser;
    public static volatile SingularAttribute<Rate, Lot> iDLot;
    public static volatile SingularAttribute<Rate, Integer> amountRate;
    public static volatile SingularAttribute<Rate, Date> dateRate;

}