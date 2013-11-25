package entity;

import entity.ArchiveProducts;
import entity.Lot;
import entity.Rate;
import entity.Rating;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2013-11-26T03:26:37")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile ListAttribute<Users, Rate> rateList;
    public static volatile ListAttribute<Users, ArchiveProducts> archiveProductsList;
    public static volatile SingularAttribute<Users, String> phoneNumber;
    public static volatile ListAttribute<Users, Lot> lotList;
    public static volatile SingularAttribute<Users, Integer> iDUser;
    public static volatile SingularAttribute<Users, String> login;
    public static volatile SingularAttribute<Users, Rating> rating;
    public static volatile SingularAttribute<Users, String> fio;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, Boolean> iSAdmin;

}