package entity;

import entity.Category;
import entity.Comments;
import entity.Rate;
import entity.Users;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-26T03:26:37")
@StaticMetamodel(Lot.class)
public class Lot_ { 

    public static volatile SingularAttribute<Lot, Date> addedDate;
    public static volatile ListAttribute<Lot, Rate> rateList;
    public static volatile SingularAttribute<Lot, Integer> tradingHours;
    public static volatile SingularAttribute<Lot, String> description;
    public static volatile SingularAttribute<Lot, Integer> startCost;
    public static volatile SingularAttribute<Lot, String> nameLot;
    public static volatile SingularAttribute<Lot, Integer> iDLot;
    public static volatile SingularAttribute<Lot, Users> iDUser;
    public static volatile ListAttribute<Lot, Comments> commentsList;
    public static volatile SingularAttribute<Lot, Category> iDCategory;
    public static volatile SingularAttribute<Lot, Integer> minRate;

}