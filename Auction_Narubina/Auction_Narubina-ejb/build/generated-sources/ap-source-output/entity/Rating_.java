package entity;

import entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-26T03:26:37")
@StaticMetamodel(Rating.class)
public class Rating_ { 

    public static volatile SingularAttribute<Rating, Users> users;
    public static volatile SingularAttribute<Rating, Integer> amountSales;
    public static volatile SingularAttribute<Rating, Integer> amountOwnLikes;
    public static volatile SingularAttribute<Rating, Integer> amountLikes;
    public static volatile SingularAttribute<Rating, Integer> amountLots;
    public static volatile SingularAttribute<Rating, Integer> iDUser;
    public static volatile SingularAttribute<Rating, Integer> mark;

}