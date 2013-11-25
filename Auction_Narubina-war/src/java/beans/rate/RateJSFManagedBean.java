/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.rate;

import client.lots.LotWebService_Service;
import client.rate.Lot;
import client.rate.Rate;
import client.rate.RateWebService_Service;
import client.rate.Users;
import client.users.UserWebService_Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Танюся
 */
@ManagedBean
@RequestScoped
public class RateJSFManagedBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/LotWebService/LotWebService.wsdl")
    private LotWebService_Service service_2 = new LotWebService_Service();
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/RateWebService/RateWebService.wsdl")
    private RateWebService_Service service_1 = new RateWebService_Service();
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/UserWebService/UserWebService.wsdl")
    private UserWebService_Service service = new UserWebService_Service();
    private List<Rate> listRate;
    private List<client.lots.Lot> listLot;
    private int idRate = 0;
    private int amountRate = 0;
    private XMLGregorianCalendar dateRate;
    private client.rate.Users idUser;
    private int idLot;
    private String login;
    private String loginUser;
    private String userRate;
    private String userRatePhone;
    private List<String> list;
    private HttpSession session;
    private String nameLot = "";
    private String description = "";
    private int startCost = 0;
    private XMLGregorianCalendar addedDate = null;
    private XMLGregorianCalendar addedDateXML;
    private int minRate = 0;
    private int tradingHours = 0;
    private String error = "";
    private List<Rate> userRateList;

    /** Creates a new instance of RateJSFManagedBean */
    public RateJSFManagedBean() {

        listRate = new ArrayList<Rate>();
        list = new ArrayList<String>();
        Date date = new Date();
        listRate = findAll();
        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            login = (String) session.getAttribute("login");
            System.out.println("KONSTR_LOT_LOGIN = " + login);
        }
        listLot = new ArrayList<client.lots.Lot>();
        listLot = findAll_2();

        userRateList = new ArrayList<Rate>();
        if (!listRate.isEmpty()) {
            for (int i = 0; i < listRate.size(); i++) {

                if (listRate.get(i).getIDUser().getLogin().equals(login)) {
                    userRateList.add(listRate.get(i));
                }
            }
            if (userRateList.isEmpty()) {
                error = "Список пуст!";
                System.out.println("беребер");
            }
        } else {
            error = "Список пуст!";
        }
    }

    public client.rate.Users findUserByLogin() {
        client.rate.Users obj = new Users();
        List<client.users.Users> listUsers = findAll_1();
        for (int i = 0; i < listUsers.size(); i++) {
            if (listUsers.get(i).getLogin().equals(login)) {
                obj.setIDUser(listUsers.get(i).getIDUser());
                obj.setLogin(listUsers.get(i).getLogin());
                return obj;
            }
        }
        return null;
    }

    public client.rate.Users findUserByLogin2() {
        client.rate.Users obj = new Users();
        List<client.users.Users> listUsers = findAll_1();
        for (int i = 0; i < listUsers.size(); i++) {
            if (listUsers.get(i).getLogin().equals(userRatePhone)) {
                obj.setIDUser(listUsers.get(i).getIDUser());
                obj.setLogin(listUsers.get(i).getLogin());
                return obj;
            }
        }
        return null;
    }

    public Rate findRateByName() {
        Rate obj = new Rate();
        for (int i = 0; i < listLot.size(); i++) {
            if (listLot.get(i).getNameLot() == nameLot) {
                obj.setIDRate(listLot.get(i).getIDLot());
                System.out.println("id"+obj);
                return obj;
            }
        }
        return null;
    }

    public String currentDays(Rate currentRate) {
        String result = new String();
        Date temp = asDate(currentRate.getIDLot().getAddedDate());
        long time = temp.getTime();
        long tempTime, currentTime;
        Date currentDate = new Date();
        currentTime = currentDate.getTime();
        tempTime = currentTime - time;
        long allHouers = currentRate.getIDLot().getTradingHours() * 24 * 60;
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

    public static java.util.Date asDate(XMLGregorianCalendar xgc) {
        if (xgc == null) {
            return null;
        } else {
            return xgc.toGregorianCalendar().getTime();
        }
    }

    public void userRate() {

        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "userRate-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);
    }
    public void viewRate() {

        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> list1 = context.getExternalContext().getRequestParameterMap();
        System.out.println("tek2" + list1.get("tek"));
        nameLot = list1.get("tek");

        client.rate.Lot lot = new client.rate.Lot();
        //idRate=findRateByName();
        for (int i = 0; i < listRate.size(); i++) {
            if (listRate.get(i).getIDLot().getNameLot() == nameLot) {
                loginUser = listRate.get(i).getIDLot().getIDUser().getLogin();
                nameLot = listRate.get(i).getIDLot().getNameLot();
                amountRate=listRate.get(i).getAmountRate();
                dateRate=listRate.get(i).getDateRate();
                idRate= listRate.get(i).getIDRate();
                addedDate = listRate.get(i).getIDLot().getAddedDate();
                description = listRate.get(i).getIDLot().getDescription();
                minRate = listRate.get(i).getIDLot().getMinRate();
                startCost = listRate.get(i).getIDLot().getStartCost();
                tradingHours = listRate.get(i).getIDLot().getTradingHours();
            }
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "viewUserRate-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);

    }

    private java.util.List<client.rate.Rate> findAll() {
        client.rate.RateWebService port = service_1.getRateWebServicePort();
        return port.findAll();
    }

    public int getAmountRate() {
        return amountRate;
    }

    public void setAmountRate(int amountRate) {
        this.amountRate = amountRate;
    }

    public XMLGregorianCalendar getDateRate() {
        return dateRate;
    }

    public void setDateRate(XMLGregorianCalendar dateRate) {
        this.dateRate = dateRate;
    }

    public int getIdLot() {
        return idLot;
    }

    public void setIdLot(int idLot) {
        this.idLot = idLot;
    }

    public int getIdRate() {
        return idRate;
    }

    public void setIdRate(int idRate) {
        this.idRate = idRate;
    }

    public Users getIdUser() {
        return idUser;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public XMLGregorianCalendar getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(XMLGregorianCalendar addedDate) {
        this.addedDate = addedDate;
    }

    public XMLGregorianCalendar getAddedDateXML() {
        return addedDateXML;
    }

    public void setAddedDateXML(XMLGregorianCalendar addedDateXML) {
        this.addedDateXML = addedDateXML;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<client.lots.Lot> getListLot() {
        return listLot;
    }

    public void setListLot(List<client.lots.Lot> listLot) {
        this.listLot = listLot;
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

    public LotWebService_Service getService_2() {
        return service_2;
    }

    public void setService_2(LotWebService_Service service_2) {
        this.service_2 = service_2;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
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

    public String getUserRate() {
        return userRate;
    }

    public void setUserRate(String userRate) {
        this.userRate = userRate;
    }

    public List<Rate> getUserRateList() {
        return userRateList;
    }

    public void setUserRateList(List<Rate> userRateList) {
        this.userRateList = userRateList;
    }

    public String getUserRatePhone() {
        return userRatePhone;
    }

    public void setUserRatePhone(String userRatePhone) {
        this.userRatePhone = userRatePhone;
    }

    public List<Rate> getListRate() {
        return listRate;
    }

    public void setListRate(List<Rate> listRate) {
        this.listRate = listRate;
    }

    public UserWebService_Service getService() {
        return service;
    }

    public void setService(UserWebService_Service service) {
        this.service = service;
    }

    public RateWebService_Service getService_1() {
        return service_1;
    }

    public void setService_1(RateWebService_Service service_1) {
        this.service_1 = service_1;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getError() {
        return error;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public void setError(String error) {
        this.error = error;
    }

    private java.util.List<client.users.Users> findAll_1() {
        client.users.UserWebService port = service.getUserWebServicePort();
        return port.findAll();
    }

    private client.users.Users find(java.lang.Object id) {
        client.users.UserWebService port = service.getUserWebServicePort();
        return port.find(id);
    }

    private java.util.List<client.lots.Lot> findAll_2() {
        client.lots.LotWebService port = service_2.getLotWebServicePort();
        return port.findAll();
    }

    private client.lots.Lot find_1(java.lang.Object id) {
        client.lots.LotWebService port = service_2.getLotWebServicePort();
        return port.find(id);
    }
}
