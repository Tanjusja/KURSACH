/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Lot;
import entity.Users;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Танюся
 */
@Remote
public interface SessionLogicRemote {

    public abstract List<Lot> getAllLots();

    public abstract List<Users> getAllUsers();

    public abstract int findUser(String login, String pass);

    public abstract int findUserByLogin(String login);

    public abstract int findLotByName(String nameLot);

    public abstract int addNewUser(String fio, String login, String pass, String phoneNumber);

    public abstract void addNewProduct(String loginUser, String nameCategory, String nameProduct, String description, int startCost, int minRate, int trading);

    public abstract List<Lot> getUserLots(String login);

    public abstract void delleteUserLot(int idlot);

//////////////////////////////////////////////////////
    public abstract Lot getLotById(int idlot);

    public abstract List<Lot> getLotsByCategory(int idcategory);

    public abstract void delleteUser(int idUser);

    public abstract Users getUserInfo(int idUser);
}
