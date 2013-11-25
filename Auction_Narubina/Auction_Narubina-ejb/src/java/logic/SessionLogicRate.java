/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Lot;
import entity.Rate;
import entity.Users;
import facade.LotFacadeLocal;
import facade.RateFacadeLocal;
import facade.UsersFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Танюся
 */
public class SessionLogicRate extends SessionLogicUser{

    @EJB
    private LotFacadeLocal lotFacade;
    @EJB
    private RateFacadeLocal rateFacade;
    @EJB
    private UsersFacadeLocal usersFacade;

    public int getRateCost(int idlot) {
        int minrate = 0;
        Lot lot = lotFacade.find(idlot);
        int rateCost = 0;
        if (lot.getMinRate() == 0) {
            rateCost = (lot.getStartCost() * 10) / 100 + lot.getStartCost();
        } else {
            rateCost = (lot.getMinRate() * 10) / 100 + lot.getMinRate();
        }
        minrate = minrate + rateCost;
        return minrate;
    }

    public List<Rate> getLotOfUserBag(String login) {

        List<Rate> list = rateFacade.findAll();
        List<Rate> tempList = new ArrayList<Rate>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIDUser().getLogin().equals(login)) {
                tempList.add(list.get(i));
            }
        }
        return tempList;
    }

    public void delleteFromUserBag(int idUserLot) {
        Rate rate = rateFacade.find(idUserLot);
        rateFacade.remove(rate);
    }

    public int addNewRate(String userLogin, int idlot, int newRate) {
        List<Rate> list = rateFacade.findAll();
        Rate rate = new Rate();
        Users user = usersFacade.find(findUserByLogin(userLogin));
        Lot lot = lotFacade.find(idlot);
        int tempRate = 0;
        if (lot.getMinRate() == 0) {
            tempRate = lot.getStartCost();
        } else {
            tempRate = lot.getMinRate();
        }
        tempRate = (tempRate * 5 / 100 + tempRate);
        if (newRate < tempRate) {
            return -2;
        } else {
            lot.setMinRate(newRate);
        }
        lotFacade.edit(lot);
        rate.setIDUser(user);
        rate.setIDLot(lot);
        Date date = new Date();
        rate.setDateRate(date);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIDLot().getIDLot() == idlot && list.get(i).getIDUser().getIDUser() == user.getIDUser()) {
                rate.setIDRate(list.get(i).getIDRate());
                rateFacade.edit(rate);
                return -1;
            }
        }
        rateFacade.create(rate);
        return 0;
    }
}
