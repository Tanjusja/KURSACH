/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.lots;

import client.lots.Category;
import client.category.CategoryWebService_Service;
import client.lots.Lot;
import client.lots.LotWebService_Service;
import client.lots.Users;
import client.rate.Rate;
import client.rate.RateWebService_Service;
import client.users.UserWebService_Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Танюся
 */
@ManagedBean
@RequestScoped
public class LotJSFManagedBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/RateWebService/RateWebService.wsdl")
    private RateWebService_Service service_3 = new RateWebService_Service();
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/UserWebService/UserWebService.wsdl")
    private UserWebService_Service service_2 = new UserWebService_Service();
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CategoryWebService/CategoryWebService.wsdl")
    private CategoryWebService_Service service_1 = new CategoryWebService_Service();
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/LotWebService/LotWebService.wsdl")
    private LotWebService_Service service = new LotWebService_Service();
    private List<Lot> listLots;
    private List<Lot> listLot;
    private List<client.rate.Rate> listRate;
    private List<client.category.Category> listCategory;
    private String nameLot = "";
    private String description = "";
    private int startCost = 0;
    private Date addedDate;
    private XMLGregorianCalendar addedDateXML;
    private int minRate = 0;
    private int tradingHours = 0;
    private int idLot = 0;
    private client.lots.Users idUser;
    private client.lots.Category idCategory;
    private String nameCategory = "";
    private String tradingHoursSTR = "";
    private String login = "";
    private String loginUser = "";
    private String errorRate = "";
    private List<client.category.Category> listCat;
    private static DatatypeFactory df = null;
    private Lot lot;
    private int amountRate = 0;
    private String userRate = "";
    private client.rate.Users idUserRate;
    private client.rate.Lot idLotRate;
    private String userRatePhone = "";
    private int newRate = 0;
    private List<Lot> userLotList;
    private HttpSession session;
    private Map<String, String> categories = new HashMap<String, String>();

    static {
        try {
            df = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException dce) {
            throw new IllegalStateException(
                    "Exception while obtaining DatatypeFactory instance", dce);
        }
    }

    public LotJSFManagedBean() {

        idUser = new client.lots.Users();
        idCategory = new client.lots.Category();
        addedDate = new Date();

        listLots = new ArrayList<Lot>();
        listLots = findAll();
        listLot = new ArrayList<Lot>();

        listCategory = new ArrayList<client.category.Category>();
        listCategory = findAll_1();

        listRate = new ArrayList<client.rate.Rate>();
        listRate = findAll_3();

        listCat = new ArrayList<client.category.Category>();
        userLotList = new ArrayList<Lot>();
        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            login = (String) session.getAttribute("login");
            System.out.println("KONSTR_LOT_LOGIN = " + login);
        }
        for (int i = 0; i < listLots.size(); i++) {
            if (listLots.get(i).getIDUser().getLogin().equals(login)) {
                userLotList.add(listLots.get(i));
            }
        }
        for (int i = 0; i < 5; i++) {
            listLot.add(listLots.get(i));
        }
        for (int i = 0; i < listCategory.size(); i++) {
            categories.put(listCategory.get(i).getNameCategory(), listCategory.get(i).getNameCategory());
            listCat.add(listCategory.get(i));

        }
        for (int i = 1; i < listCategory.size(); i++) {
            listCat.add(listCategory.get(i));
        }

    }

    public void viewLots() {
        List<Lot> listTemp = new ArrayList<Lot>();
        listTemp = findAll();
        if (!listLots.isEmpty()) {
            listLots.clear();
        }
        for (int i = 0; i < listTemp.size(); i++) {
            if (currentTime(listTemp.get(0)) == 0) {
                listLots.add(listTemp.get(i));
            }
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "allLots-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);
    }

    public int currentTime(Lot currentLot) {
        String result = new String();
        Date temp = asDate(currentLot.getAddedDate());
        long time = temp.getTime();
        long tempTime, currentTime;
        Date currentDate = new Date();
        currentTime = currentDate.getTime();
        tempTime = currentTime - time;
        if (tempTime <= -1) {
            return 0;
        } else {
            return 0;
        }
    }

    public String currentDays(Lot currentLot) {
        String result = new String();
        Date temp = asDate(currentLot.getAddedDate());
        long time = temp.getTime();
        long tempTime, currentTime;
        Date currentDate = new Date();
        currentTime = currentDate.getTime();
        tempTime = currentTime - time;
        long allHouers = currentLot.getTradingHours() * 24 * 60;
        tempTime = tempTime / (1000 * 60);
        tempTime = allHouers - tempTime;
        if (tempTime <= 0) {
            result = null;
            return result;
        }
        int days = 0, houers = 0, minutes = 0;
        days = (int) tempTime / (24 * 60);
        if (days != 0) {
            result = " Дни: " + days;
            tempTime -= days * 24 * 60;
        }
        houers = (int) tempTime / 60;
        if (houers != 0) {
            result += " Часы: " + houers;
            tempTime -= houers * 60;
        }
        minutes = (int) tempTime;
        if (minutes != 0) {
            result += " Минуты: " + minutes;
        }
        return result;
    }

    public client.lots.Users findUserByLogin() {
        client.lots.Users obj = new Users();
        List<client.users.Users> listUsers = findAll_2();
        for (int i = 0; i < listUsers.size(); i++) {
            if (listUsers.get(i).getLogin().equals(login)) {
                obj.setIDUser(listUsers.get(i).getIDUser());
                obj.setLogin(listUsers.get(i).getLogin());
                return obj;
            }
        }
        return null;
    }

    public client.lots.Category findCategoryByName() {
        client.lots.Category obj = new Category();
        List<client.category.Category> listCategory = findAll_1();
        for (int i = 0; i < listCategory.size(); i++) {
            if (listCategory.get(i).getNameCategory().equals(nameCategory)) {
                obj.setIDCategory(listCategory.get(i).getIDCategory());
                obj.setNameCategory(listCategory.get(i).getNameCategory());
                return obj;
            }
        }
        return null;
    }

    public static XMLGregorianCalendar asXMLGregorianCalendar(java.util.Date date) {
        if (date == null) {
            return null;
        } else {
            GregorianCalendar gc = new GregorianCalendar();
            gc.setTimeInMillis(date.getTime());
            return df.newXMLGregorianCalendar(gc);
        }
    }

    public static java.util.Date asDate(XMLGregorianCalendar xgc) {
        if (xgc == null) {
            return null;
        } else {
            return xgc.toGregorianCalendar().getTime();
        }
    }

    public void addPage() {

        if (session.getAttribute("login") == null) {
            errorRate = "Страница недоступна! Пройдите авторизацию!";
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String redirect = "StartPage-jsf.xhtml";
            NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
            myNav.handleNavigation(facesContext, null, redirect);
            return;
        }
        login = (String) session.getAttribute("login");
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "AddLot-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);

    }

    public int addNewLot() {

        if (session.getAttribute("login") == null) {
            errorRate = "Страница недоступна! Пройдите авторизацию!";
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String redirect = "StartPage-jsf.xhtml";
            NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
            myNav.handleNavigation(facesContext, null, redirect);
            return -1;
        }
        login = (String) session.getAttribute("login");
        Category category = new Category();
        System.out.println("category");
        Lot lot = new Lot();
        Date date = new Date();
        lot.setNameLot(getNameLot());
        lot.setDescription(getDescription());
        lot.setAddedDate(asXMLGregorianCalendar(date));
        lot.setStartCost(getStartCost());
        lot.setMinRate(getMinRate());
        lot.setTradingHours(getTradingHours());

        for (int i = 0; i < listCategory.size(); i++) {
            if (nameCategory.equals(listCategory.get(i).getNameCategory())) {

                category.setNameCategory(listCategory.get(i).getNameCategory());
                idCategory = findCategoryByName();
                System.out.println("category" + idCategory);
                lot.setIDCategory(idCategory);
                System.out.println("category" + idCategory);
            }
        }
        idUser = findUserByLogin();
        lot.setIDUser(idUser);
        lot.setIDLot(1);
        create(lot);
        listLots = findAll();
        userLotList = new ArrayList<Lot>();

        for (int i = 0; i < listLots.size(); i++) {
            if (listLots.get(i).getIDUser().getLogin().equals(login)) {
                userLotList.add(listLots.get(i));
            }
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "UserLot-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);

        return 0;
    }

    public void deleteLot() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (session.getAttribute("login") == null) {
            errorRate = "Страница недоступна! Пройдите авторизацию!";
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String redirect = "StartPage-jsf.xhtml";
            NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
            myNav.handleNavigation(facesContext, null, redirect);
            return;
        }
        Map<String, String> list1 = context.getExternalContext().getRequestParameterMap();
        login = (String) session.getAttribute("login");
        System.out.println("LOGIN = " + login);
        System.out.println("regta");
        Lot lotSel = new Lot();

        System.out.println("tek1 = " + list1.get("tek"));
        idLot = Integer.parseInt(list1.get("tek"));

        for (int i = 0; i < listLots.size(); i++) {

            if (listLots.get(i).getIDLot() == idLot) {
                lotSel.setIDLot(listLots.get(i).getIDLot());
                lotSel.setNameLot(listLots.get(i).getNameLot());
                lotSel.setDescription(listLots.get(i).getDescription());
                lotSel.setAddedDate(listLots.get(i).getAddedDate());
                lotSel.setStartCost(listLots.get(i).getStartCost());
                lotSel.setMinRate(listLots.get(i).getMinRate());
                lotSel.setTradingHours(listLots.get(i).getTradingHours());
                lotSel.setIDUser(listLots.get(i).getIDUser());
                lotSel.setIDCategory(listLots.get(i).getIDCategory());
                remove(lotSel);
            }
        }

        listLots = findAll();
        userLotList = new ArrayList<Lot>();

        for (int i = 0; i < listLots.size(); i++) {
            if (listLots.get(i).getIDUser().getLogin().equals(login)) {
                userLotList.add(listLots.get(i));
            }
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "UserLot-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);

    }

    public void ViewLotsByCategory() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> list = context.getExternalContext().getRequestParameterMap();
        int idCategory = Integer.parseInt(list.get("tek"));
        for (int i = 0; i < listLots.size(); i++) {
            //if(listLots.get(i).getIDCategory()==idCategory)
        }
    }

    public void editLot() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (session.getAttribute("login") == null) {
            errorRate = "Страница недоступна! Пройдите авторизацию!";
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String redirect = "StartPage-jsf.xhtml";
            NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
            myNav.handleNavigation(facesContext, null, redirect);
            return;
        }
        login = (String) session.getAttribute("login");
        Map<String, String> list1 = context.getExternalContext().getRequestParameterMap();
        idLot = Integer.parseInt(list1.get("tek"));
        Lot lotSel = new Lot();
        lotSel = find(idLot);

        this.setNameLot(lotSel.getNameLot());
        this.setDescription(lotSel.getDescription());
        this.setStartCost(lotSel.getStartCost());
        this.setMinRate(lotSel.getMinRate());
        this.setTradingHours(lotSel.getTradingHours());
        this.setIdCategory(lotSel.getIDCategory());
        this.setNameCategory(this.idCategory.getNameCategory());


        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "EditLot-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);
    }

    public void editAddLot() {

        Category category = new Category();
        FacesContext context = FacesContext.getCurrentInstance();
        if (session.getAttribute("login") == null) {
            errorRate = "Страница недоступна! Пройдите авторизацию!";
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String redirect = "StartPage-jsf.xhtml";
            NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
            myNav.handleNavigation(facesContext, null, redirect);
            return;
        }
        Map<String, String> list1 = context.getExternalContext().getRequestParameterMap();
        login = (String) session.getAttribute("login");
        Lot lotSel = new Lot();


        idLot = Integer.parseInt(list1.get("tek"));
        lotSel = find(idLot);
        for (int i = 0; i < listCategory.size(); i++) {
            if (nameCategory.equals(listCategory.get(i).getNameCategory())) {

                category.setNameCategory(listCategory.get(i).getNameCategory());
                //category.setIDCategory(listCategory.get(i).getIDCategory());
                idCategory = findCategoryByName();
                System.out.println("category" + idCategory);
                lotSel.setIDCategory(idCategory);
                System.out.println("category" + idCategory);
            }
        }
        for (int i = 0; i < listLots.size(); i++) {
            if (!listLots.get(i).getNameLot().equals(nameLot) && !listLots.get(i).getDescription().equals(description)
                    && listLots.get(i).getStartCost() != startCost && listLots.get(i).getMinRate() != minRate && listLots.get(i).getTradingHours() != tradingHours) {
                lotSel.setNameLot(getNameLot());
                // idCategory = findCategoryByName();
                lotSel.setDescription(getDescription());
                lotSel.setStartCost(getStartCost());
                lotSel.setMinRate(getMinRate());
                lotSel.setTradingHours(getTradingHours());
            } else {
                errorRate = "Для редактирования введите другие данные!!!";
            }
        }
        edit(lotSel);
        listLots = findAll();
        userLotList = new ArrayList<Lot>();
        for (int i = 0; i < listLots.size(); i++) {
            if (listLots.get(i).getIDUser().getLogin().equals(login)) {
                userLotList.add(listLots.get(i));
            }
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "UserLot-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);

    }

    public void userLot() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (session.getAttribute("login") == null) {
            errorRate = "Страница недоступна! Пройдите авторизацию!";
            String redirect = "StartPage-jsf.xhtml";
            NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
            myNav.handleNavigation(facesContext, null, redirect);
            return;
        }
        login = (String) session.getAttribute("login");

        System.out.println("LOGIN1 = " + login);
        listLots = findAll();
        userLotList = new ArrayList<Lot>();

        lot = new Lot();
        if (!listLots.isEmpty()) {
            for (int i = 0; i < listLots.size(); i++) {

                if (listLots.get(i).getIDUser().getLogin().equals(login)) {
                    userLotList.add(listLots.get(i));
                }
            }
            if (userLotList.isEmpty()) {
                errorRate = "Список пуст!";
                System.out.println("беребер");
            }

        } else {
            errorRate = "Список пуст!";
            System.out.println("беребер2");
        }

        String redirect = "UserLot-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);
    }

    public void userPage() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (session.getAttribute("login") == null) {
            errorRate = "Страница недоступна! Пройдите авторизацию!";
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String redirect = "StartPage-jsf.xhtml";
            NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
            myNav.handleNavigation(facesContext, null, redirect);
            return;
        }
        login = (String) session.getAttribute("login");

        System.out.println("LOGIN1 = " + login);
        listLots = findAll();
        userLotList = new ArrayList<Lot>();
        lot = new Lot();
        for (int i = 0; i < listLots.size(); i++) {
            if (listLots.get(i).getIDUser().getLogin().equals(login)) {
                userLotList.add(listLots.get(i));
            }

            FacesContext facesContext = FacesContext.getCurrentInstance();
            String redirect = "Lots-jsf.xhtml";
            NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
            myNav.handleNavigation(facesContext, null, redirect);
        }
    }

    public int viewLot() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (session.getAttribute("login") == null) {
            errorRate = "Страница недоступна! Пройдите авторизацию!";
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String redirect = "StartPage-jsf.xhtml";
            NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
            myNav.handleNavigation(facesContext, null, redirect);
            return -1;
        }
        login = (String) session.getAttribute("login");
        Map<String, String> list1 = context.getExternalContext().getRequestParameterMap();
        System.out.println("tek2" + list1.get("tek"));
        idLot = Integer.parseInt(list1.get("tek"));

        for (int i = 0; i < listLots.size(); i++) {
            if (listLots.get(i).getIDLot() == idLot) {
                loginUser = listLots.get(i).getIDUser().getLogin();
                nameLot = listLots.get(i).getNameLot();
                idLot = listLots.get(i).getIDLot();
                addedDateXML = listLots.get(i).getAddedDate();
                description = listLots.get(i).getDescription();
                minRate = listLots.get(i).getMinRate();
                startCost = listLots.get(i).getStartCost();
                tradingHours = listLots.get(i).getTradingHours();
                listRate = new ArrayList<client.rate.Rate>();
                listRate = findAll_3();

                if (!listRate.isEmpty()) {
                    for (int j = 0; j < listRate.size(); j++) {
                        if (listRate.get(j).getIDLot().getIDLot() == idLot) {
                            System.out.println("NOT EMPTY!");
                            amountRate = listRate.get(j).getAmountRate();
                            userRate = listRate.get(j).getIDUser().getLogin();
                            userRatePhone = listRate.get(j).getIDUser().getPhoneNumber();
                        }
                    }
                } else {
                    System.out.println("IS EMPTY!((((((((((((((((((((((((");
                }
            }
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "viewLot-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);
        return idLot;

    }

    public client.rate.Users findUserByLogin2() {
        client.rate.Users obj = new client.rate.Users();
        List<client.users.Users> listUsers = findAll_2();
        for (int i = 0; i < listUsers.size(); i++) {
            if (listUsers.get(i).getLogin().equals(login)) {
                obj.setIDUser(listUsers.get(i).getIDUser());
                obj.setLogin(listUsers.get(i).getLogin());
                obj.setPhoneNumber(listUsers.get(i).getPhoneNumber());
                return obj;
            }
        }
        return null;
    }

    public int findLotByName() {
        for (int i = 0; i < listLots.size(); i++) {
            if (listLots.get(i).getNameLot().equals(nameLot)) {
                return listLots.get(i).getIDLot();
            }
        }
        return 0;
    }

    public client.rate.Lot findLotByName2() {
        client.rate.Lot obj = new client.rate.Lot();
        List<client.lots.Lot> listLots = findAll();
        for (int i = 0; i < listLots.size(); i++) {
            if (listLots.get(i).getIDLot() == idLot) {
                obj.setIDLot(listLots.get(i).getIDLot());
                obj.setNameLot(listLots.get(i).getNameLot());
                return obj;
            }
        }
        return null;
    }

    public int addNewRate() {

        FacesContext context = FacesContext.getCurrentInstance();
        if (session.getAttribute("login") == null) {
            errorRate = "Страница недоступна! Пройдите авторизацию!";
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String redirect = "StartPage-jsf.xhtml";
            NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
            myNav.handleNavigation(facesContext, null, redirect);
            return -1;
        }
        login = (String) session.getAttribute("login");
        Map<String, String> list1 = context.getExternalContext().getRequestParameterMap();
        System.out.println("tek2" + list1.get("tek"));

        idLot = Integer.parseInt(list1.get("tek"));
        lot = find(idLot);
        int tempAmountRate = 0;

        for (int i = 0; i < listRate.size(); i++) {
            if (listRate.get(i).getIDLot().getIDLot() == idLot) {

                tempAmountRate = listRate.get(i).getAmountRate() + lot.getMinRate();
                break;
            }
        }
        if (tempAmountRate == 0) {
            tempAmountRate = lot.getStartCost() + lot.getMinRate();
        }

        Rate rate = new Rate();
        int tempParam = 0;
        idUserRate = findUserByLogin2();
        if (newRate < tempAmountRate) {
            errorRate = "Ставка меньше предыдущей! Минимальная ставка = " + tempAmountRate;
            tempParam = viewLot();
            return -2;
        } else {
            rate.setAmountRate(newRate);
        }
        rate.setIDUser(idUserRate);
        idLotRate = findLotByName2();
        rate.setIDLot(idLotRate);
        Date date = new Date();
        rate.setDateRate(asXMLGregorianCalendar(date));
        for (int i = 0; i < listRate.size(); i++) {
            if (listRate.get(i).getIDLot().getIDLot() == idLot) {
                rate.setIDRate(listRate.get(i).getIDRate());
                edit_3(rate);
                tempParam = viewLot();
                return 0;
            }
        }
        rate.setIDRate(1);
        create_3(rate);
        tempParam = viewLot();
        return 0;
    }

    public void extendLot() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (session.getAttribute("login") == null) {
            errorRate = "Страница недоступна! Пройдите авторизацию!";
            FacesContext facesContext = FacesContext.getCurrentInstance();
            String redirect = "StartPage-jsf.xhtml";
            NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
            myNav.handleNavigation(facesContext, null, redirect);
            return;
        }
        login = (String) session.getAttribute("login");
        Map<String, String> list1 = context.getExternalContext().getRequestParameterMap();
        Lot lotSel = new Lot();

        System.out.println("tek1 = " + list1.get("tek"));
        idLot = Integer.parseInt(list1.get("tek"));
        lotSel = findLotByID();

        lotSel.setAddedDate(asXMLGregorianCalendar(new Date()));
        edit(lotSel);
        listLots = findAll();
        userLotList = new ArrayList<Lot>();

        for (int i = 0; i < listLots.size(); i++) {
            if (listLots.get(i).getIDUser().getLogin().equals(login)) {
                userLotList.add(listLots.get(i));
            }
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "UserLot-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);

    }

    private void create(client.lots.Lot lot) {
        client.lots.LotWebService port = service.getLotWebServicePort();
        port.create(lot);
    }

    private client.category.Category find_1(java.lang.Object id) {
        client.category.CategoryWebService port = service_1.getCategoryWebServicePort();
        return port.find(id);
    }

    private client.users.Users find_2(java.lang.Object id) {
        client.users.UserWebService port = service_2.getUserWebServicePort();
        return port.find(id);
    }

    private java.util.List<client.lots.Lot> findAll() {
        client.lots.LotWebService port = service.getLotWebServicePort();
        return port.findAll();
    }

    private java.util.List<client.users.Users> findAll_2() {
        client.users.UserWebService port = service_2.getUserWebServicePort();
        return port.findAll();
    }
    
    private void remove(client.lots.Lot lot) {
        client.lots.LotWebService port = service.getLotWebServicePort();
        port.remove(lot);
    }

    private Lot find(java.lang.Object id) {
        client.lots.LotWebService port = service.getLotWebServicePort();
        return port.find(id);
    }

    public Lot findLotByID() {
        return find(idLot);
    }

    private void edit(client.lots.Lot lot) {
        client.lots.LotWebService port = service.getLotWebServicePort();
        port.edit(lot);
    }

    private java.util.List<client.category.Category> findAll_1() {
        client.category.CategoryWebService port = service_1.getCategoryWebServicePort();
        return port.findAll();
    }

    private void edit_3(client.rate.Rate rate) {
        client.rate.RateWebService port = service_3.getRateWebServicePort();
        port.edit(rate);
    }

    private Rate find_3(java.lang.Object id) {
        client.rate.RateWebService port = service_3.getRateWebServicePort();
        return port.find(id);
    }

    private void create_3(client.rate.Rate rate) {
        client.rate.RateWebService port = service_3.getRateWebServicePort();
        port.create(rate);
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getTradingHoursSTR() {
        return tradingHoursSTR;
    }

    public void setTradingHoursSTR(String tradingHoursSTR) {
        this.tradingHoursSTR = tradingHoursSTR;
    }

    public List<client.category.Category> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<client.category.Category> listCategory) {
        this.listCategory = listCategory;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public List<Lot> getListLots() {
        return listLots;
    }

    public void setListLots(List<Lot> listLots) {
        this.listLots = listLots;
    }

    public int getMinRate() {
        return minRate;
    }

    public void setMinRate(int minRate) {
        this.minRate = minRate;
    }

    public String getNameLot() {
        return nameLot;
    }

    public void setNameLot(String nameLot) {
        this.nameLot = nameLot;
    }

    public List<Lot> getUserLotList() {
        return userLotList;
    }

    public String getErrorRate() {
        return errorRate;
    }

    public void setErrorRate(String errorRate) {
        this.errorRate = errorRate;
    }

    public Map<String, String> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, String> categories) {
        this.categories = categories;
    }

    public void setUserLotList(List<Lot> userLotList) {
        this.userLotList = userLotList;
    }

    public int getIdLot() {
        return idLot;
    }

    public void setIdLot(int idLot) {
        this.idLot = idLot;
    }

    public Category getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Category idCategory) {
        this.idCategory = idCategory;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public List<Lot> getListLot() {
        return listLot;
    }

    public void setListLot(List<Lot> listLot) {
        this.listLot = listLot;
    }

    public LotWebService_Service getService() {
        return service;
    }

    public void setService(LotWebService_Service service) {
        this.service = service;
    }

    public int getStartCost() {
        return startCost;
    }

    public void setStartCost(int startCost) {
        this.startCost = startCost;
    }

    public int getTradingHours() {
        return tradingHours;
    }

    public void setTradingHours(int tradingHours) {
        this.tradingHours = tradingHours;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<client.category.Category> getListCat() {
        return listCat;
    }

    public void setListCat(List<client.category.Category> listCat) {
        this.listCat = listCat;
    }

    public CategoryWebService_Service getService_1() {
        return service_1;
    }

    public void setService_1(CategoryWebService_Service service_1) {
        this.service_1 = service_1;
    }

    public UserWebService_Service getService_2() {
        return service_2;
    }

    public void setService_2(UserWebService_Service service_2) {
        this.service_2 = service_2;
    }

    public static DatatypeFactory getDf() {
        return df;
    }

    public String getUserRate() {
        return userRate;
    }

    public void setUserRate(String userRate) {
        this.userRate = userRate;
    }

    public static void setDf(DatatypeFactory df) {
        LotJSFManagedBean.df = df;
    }

    public Lot getLot() {
        return lot;
    }

    public List<client.rate.Rate> getListRate() {
        return listRate;
    }

    public void setListRate(List<client.rate.Rate> listRate) {
        this.listRate = listRate;
    }

    public XMLGregorianCalendar getAddedDateXML() {
        return addedDateXML;
    }

    public void setAddedDateXML(XMLGregorianCalendar addedDateXML) {
        this.addedDateXML = addedDateXML;
    }

    public RateWebService_Service getService_3() {
        return service_3;
    }

    public void setService_3(RateWebService_Service service_3) {
        this.service_3 = service_3;
    }

    public int getAmountRate() {
        return amountRate;
    }

    public String getUserRatePhone() {
        return userRatePhone;
    }

    public void setUserRatePhone(String userRatePhone) {
        this.userRatePhone = userRatePhone;
    }

    public void setAmountRate(int amountRate) {
        this.amountRate = amountRate;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public client.rate.Users getIdUserRate() {
        return idUserRate;
    }

    public void setIdUserRate(client.rate.Users idUserRate) {
        this.idUserRate = idUserRate;
    }

    private java.util.List<client.rate.Rate> findAll_3() {
        client.rate.RateWebService port = service_3.getRateWebServicePort();
        return port.findAll();
    }

    public int getNewRate() {
        return newRate;
    }

    public void setNewRate(int newRate) {
        this.newRate = newRate;
    }

    public client.rate.Lot getIdLotRate() {
        return idLotRate;
    }

    public void setIdLotRate(client.rate.Lot idLotRate) {
        this.idLotRate = idLotRate;
    }

}
