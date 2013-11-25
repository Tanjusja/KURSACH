/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Lot;
import entity.Users;
import facade.LotFacadeLocal;
import facade.UsersFacadeLocal;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;


public class SessionLogicUser implements SessionLogicRemote{

    @EJB
    private UsersFacadeLocal usersFacade;

    public int findUser(String login, String pass) {
        List<Users> list = usersFacade.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogin().equals(login) && list.get(i).getPassword().equals(pass)) {
                if (list.get(i).getISAdmin()) {
                    return 2;
                }
                return 1;
            }
        }
        return -1;
    }

    @Override
    public int addNewUser(String fio, String login, String pass, String phoneNumber) {
        Users user = new Users();
        user.setFio(fio);
        user.setLogin(login);
        user.setPassword(pass);
        user.setISAdmin(false);
        user.setPhoneNumber(phoneNumber);
        List<Users> list = usersFacade.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogin().equals(login)) {
                return -1;
            }
        }
        usersFacade.create(user);
        return 0;
    }

    @Override
    public int findUserByLogin(String login) {
        List<Users> list = usersFacade.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLogin().equals(login)) {
                return list.get(i).getIDUser();
            }
        }
        return 0;
    }

    @Override
    public List<Lot> getUserLots(String login) {
        Users userL = usersFacade.find(this.findUserByLogin(login));
        return userL.getLotList();
    }

    @Override
    public void delleteUser(int idUser) {
        usersFacade.remove(usersFacade.find(idUser));
    }

    @Override
    public List<Users> getAllUsers() {

        List<Users> list = usersFacade.findAll();

        return list;
    }

    @Override
    public Users getUserInfo(int idUser) {

        Users user = usersFacade.find(idUser);

        return user;
    }

    @Override
    public int findLotByName(String nameLot) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void addNewProduct(String loginUser, String nameCategory, String nameProduct, String description, int startCost, int minRate, int trading) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delleteUserLot(int idlot) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Lot> getAllLots() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Lot getLotById(int idlot) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Lot> getLotsByCategory(int idcategory) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
