/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.ArchiveProducts;
import entity.Category;
import entity.Comments;
import entity.Lot;
import entity.Rate;
import entity.Users;
import facade.ArchiveProductsFacadeLocal;
import facade.CategoryFacadeLocal;
import facade.CommentsFacadeLocal;
import facade.LotFacadeLocal;
import facade.RateFacadeLocal;
import facade.UsersFacadeLocal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author Танюся
 */

public class SessionLogicLot implements SessionLogicRemote {

    @EJB
    private LotFacadeLocal lotFacade;
    @EJB
    private RateFacadeLocal rateFacade;
    @EJB
    private UsersFacadeLocal usersFacade;
    @EJB
    private CategoryFacadeLocal categoryFacade;
    private int tempSumm;


    public List<Lot> getAllLots() {

        List<Lot> list = lotFacade.findAll();
        return list;
    }

    public int findCategoryByName(String nameCategory) {
        List<Category> list = categoryFacade.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNameCategory().equals(nameCategory)) {
                return list.get(i).getIDCategory();
            }
        }
        return 0;
    }
    @Override
    public void addNewProduct(String loginUser, String nameCategory, String nameProduct, String description, int startCost, int minRate, int trading) {
        Date date = new Date();
        Users user = usersFacade.find(this.findUserByLogin(loginUser));
        Category category = categoryFacade.find(this.findCategoryByName(nameCategory));
        Lot lot = new Lot();
        lot.setAddedDate(date);
        lot.setDescription(description);
        lot.setIDCategory(category);
        lot.setIDUser(user);
        lot.setNameLot(nameProduct);
        lot.setStartCost(startCost);
        lot.setMinRate(minRate);
        lot.setTradingHours(trading);
        lotFacade.create(lot);
    }

    @Override
    public int findLotByName(String nameLot) {
        List<Lot> list = lotFacade.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNameLot().equals(nameLot)) {
                return list.get(i).getIDLot();
            }
        }
        return 0;
    }

    public List<Lot> getLotsByCategory(int idcategory) {
        List<Lot> list = lotFacade.findAll();
        List<Lot> tempList = new ArrayList<Lot>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getIDCategory().getIDCategory() == idcategory) {
                tempList.add(list.get(i));
            }
        }

        return tempList;
    }

    @Override
    public void delleteUserLot(int idlot) {
        Lot lot = lotFacade.find(idlot);
        lotFacade.remove(lot);
    }

    public void redactUserLot(String nameLot, String description, String typeofproduct, int idlot, int cost) {
        Lot lot = new Lot();
        Lot tempLot = lotFacade.find(idlot);
        lot.setNameLot(nameLot);
        lot.setAddedDate(tempLot.getAddedDate());
        lot.setDescription(description);
        lot.setIDCategory(tempLot.getIDCategory());
        lot.setIDUser(tempLot.getIDUser());
        lot.setIDLot(idlot);
        lot.setStartCost(cost);
        lotFacade.edit(lot);
    }

    public double[] myTrend(double[] mass) {
        this.tempSumm = 0;
        double tempSummValue = 0.0;
        double[] A = new double[10];
        double[] A1 = new double[10];
        double[] A2 = new double[10];
        double[] ARezult = new double[30];

        double[] REZULTMUSS = new double[30];
        double[] S = new double[30];
        int a = 0, b = 0;// T = a + bt +e;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 10; j++) {
                tempSummValue += mass[j];
            }
            tempSummValue = tempSummValue / 10;
            for (int k = 0; k < 10; k++) {
                A[k] = mass[i * 10 + k] - tempSummValue;
            }
        }

        for (int i = 1; i < 2; i++) {
            tempSummValue = 0;
            for (int j = 0; j < 10; j++) {
                tempSummValue += mass[i * 10 + j];
            }
            tempSummValue = tempSummValue / 10;
            for (int k = 0; k < 10; k++) {
                A1[k] = mass[i * 10 + k] - tempSummValue;
            }
        }
        tempSummValue = 0;
        for (int i = 2; i < 3; i++) {
            tempSummValue = 0;
            for (int j = 0; j < 10; j++) {
                tempSummValue += mass[i * 10 + j];
            }
            tempSummValue = tempSummValue / 10;
            for (int k = 0; k < 10; k++) {
                A2[k] = mass[i * 10 + k] - tempSummValue;
            }
        }
        tempSummValue = 0;
        for (int i = 0; i < 10; i++) {
            ARezult[i] = (A[i] + A1[i] + A2[i]) / 3;
            ARezult[i + 10] = (A[i] + A1[i] + A2[i]) / 3;
            ARezult[i + 20] = (A[i] + A1[i] + A2[i]) / 3;
        }
        for (int j = 0; j < 30; j++) {
            tempSummValue += mass[j];
        }
        a = (int) tempSummValue / 60;
        tempSummValue = 0;
        for (int i = 0; i < 10; i++) {
            tempSummValue += Math.abs(ARezult[i]);
        }
        b = (int) tempSummValue / 20;

        for (int j = 0; j < 30; j++) {
            REZULTMUSS[j] = a + b * (j + 11) + ARezult[j];
        }
        for (int i = 0; i < 30; i++) {
            this.tempSumm += (int) REZULTMUSS[i] / 10 * 1024;
        }
        return REZULTMUSS;
    }

    public double[] generateValues() {
        try {
            int randomInt = 0;
            int randomSize = 0;
            int maxSize = 30720;
            double temp = 0;
            double[] mass = new double[30];
            Random random = new Random(new Date().getTime());
            boolean randomBoolean = random.nextBoolean();
            for (int i = 0; i < 30; i++) {
                randomInt = random.nextInt(10);
                for (int j = 0; j < randomInt; j++) {
                    randomSize = random.nextInt(30720);
                    mass[i] += randomSize;
                }
                mass[i] = mass[i] / 1024;
                mass[i] += temp;
                temp = mass[i];
            }
            return mass;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Lot getLotById(int idlot) {

        Lot lot = lotFacade.find(idlot);
        return lot;
    }

    @Override
    public List<Users> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int findUser(String login, String pass) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int findUserByLogin(String login) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int addNewUser(String fio, String login, String pass, String phoneNumber) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Lot> getUserLots(String login) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void delleteUser(int idUser) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Users getUserInfo(int idUser) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
