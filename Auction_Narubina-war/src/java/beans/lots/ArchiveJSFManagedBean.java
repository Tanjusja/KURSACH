/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.lots;

import client.archive.ArchiveProducts;
import client.archive.ArchiveWebService_Service;
import client.archive.Users;
import client.category.Category;
import client.lots.Lot;
import client.lots.LotWebService_Service;
import client.rate.Rate;
import client.rate.RateWebService_Service;
import client.users.UserWebService_Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
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
public class ArchiveJSFManagedBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/UserWebService/UserWebService.wsdl")
    private UserWebService_Service service_3 = new UserWebService_Service();
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/RateWebService/RateWebService.wsdl")
    private RateWebService_Service service_2 = new RateWebService_Service();
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/LotWebService/LotWebService.wsdl")
    private LotWebService_Service service_1 = new LotWebService_Service();
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ArchiveWebService/ArchiveWebService.wsdl")
    private ArchiveWebService_Service service = new ArchiveWebService_Service();
    private Date addedDate = null;
    private String buyedOfUser = "";
    private String login = "";
    private int idLot;
    private int idProduct = 0;
    private client.archive.Users idUser;
    private XMLGregorianCalendar lastDateRate = null;
    private String nameLot = "";
    private int startCost = 0;
    private List<ArchiveProducts> listProducts;
    private List<Lot> listLots;
    private List<String> list;
    private HttpSession session;
    private String loginUser;
    private XMLGregorianCalendar addedDateXML;
    private String description;
    private int minRate;
    private int tradingHours;
    private List<client.rate.Rate> listRate;
    private List<client.rate.Rate> listRat;
    private int amountRate;
    private String userRate;
    private String userRatePhone;
    private List<Lot> userLotList;
    private List<client.users.Users> listUsers;
    private static DatatypeFactory df = null;
    private String errorRate = "";
    private String error = "";

    /** Creates a new instance of ArchiveJSFManagedBean */
    public ArchiveJSFManagedBean() {
        listProducts = new ArrayList<ArchiveProducts>();
        listLots = new ArrayList<Lot>();
        listLots = findAll();
        //listProducts = findAll();
        list = new ArrayList<String>();
        listRate = new ArrayList<client.rate.Rate>();
        listRat = new ArrayList<client.rate.Rate>();
        listUsers = new ArrayList<client.users.Users>();
        listUsers = findAll_1();
        userLotList = new ArrayList<Lot>();

        session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null) {
            login = (String) session.getAttribute("login");
            System.out.println("KONSTR_LOT_LOGIN = " + login);
        }
        if (!listLots.isEmpty()) {
            for (int i = 0; i < listLots.size(); i++) {
                if (listLots.get(i).getIDUser().getLogin().equals(login)) {
                    userLotList.add(listLots.get(i));
                }
            }
            if (userLotList.isEmpty()) {
                error = "Список пуст!";
            }
        } else {
            error = "Список пуст!";
        }
    }

    static {
        try {
            df = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException dce) {
            throw new IllegalStateException(
                    "Exception while obtaining DatatypeFactory instance", dce);
        }
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

    public Lot findLotByID() {
        return find(idLot);
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

    public int viewLot() {
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> list1 = context.getExternalContext().getRequestParameterMap();

        System.out.println("tek2" + list1.get("tek"));
        idLot = Integer.parseInt(list1.get("tek"));

        //lot = new Lot();
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
                }

            }
        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "viewUserLot-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);
        return idLot;

    }

    public void deleteLot() {
        listRate = findAll_3();
        FacesContext context = FacesContext.getCurrentInstance();
        Map<String, String> list1 = context.getExternalContext().getRequestParameterMap();
        login = (String) session.getAttribute("login");
        client.archive.Users obj = new Users();
        for (int j = 0; j < listUsers.size(); j++) {
            if (listUsers.get(j).getLogin().equals(login)) {
                System.out.println("NOT EMPTY!");
                obj.setLogin(listUsers.get(j).getLogin());
                obj.setIDUser(listUsers.get(j).getIDUser());
            }
        }

        Lot lotSel = new Lot();

        System.out.println("tek1 = " + list1.get("tek"));
        idLot = Integer.parseInt(list1.get("tek"));
        listLots = findAll();

        Date date = new Date();
        int tempParam = 0;

        if (!listRate.isEmpty()) {
            for (int j = 0; j < listRate.size(); j++) {
                if (listRate.get(j).getIDLot().getIDLot() == idLot) {
                    System.out.println("NOT EMPTY!");
                    amountRate = listRate.get(j).getAmountRate();
                    lastDateRate = listRate.get(j).getDateRate();
                    buyedOfUser = listRate.get(j).getIDUser().getLogin();
                    
                    listRat.add(listRate.get(j));

                    client.archive.ArchiveProducts product = new client.archive.ArchiveProducts();
                    product.setLastDateRate(lastDateRate);
                    product.setBuyedOfUser(buyedOfUser);
                    product.setIDUser(obj);
                    product.setIDProduct(1);

                    listLots = findAll();
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
                            product.setNameLot(lotSel.getNameLot());
                            product.setAddedDate(lotSel.getAddedDate());
                            product.setStartCost(lotSel.getStartCost());
                            create(product);
                            remove(lotSel);
                        }
                    }
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    String redirect = "saleLot-jsf.xhtml";
                    NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
                    myNav.handleNavigation(facesContext, null, redirect);
                } 
            }
            if(listRat.isEmpty()) {
                    System.out.println("IS EMPTY___2!(((((");
                    amountRate = 0;
                    lastDateRate = asXMLGregorianCalendar(date);
                    buyedOfUser = obj.getLogin();
                    errorRate = "Ставок на данный лот нет!";
                    tempParam = viewLot();
                }

        } else {
            System.out.println("IS EMPTY!(((");
            tempParam = viewLot();
            errorRate = "Ставки отсутствуют!";
        }
    }

    private void create(client.archive.ArchiveProducts archiveProducts) {
        client.archive.ArchiveWebService port = service.getArchiveWebServicePort();
        port.create(archiveProducts);
    }

    public int getAmountRate() {
        return amountRate;
    }

    public void setAmountRate(int amountRate) {
        this.amountRate = amountRate;
    }

    public String getUserRate() {
        return userRate;
    }

    public void setUserRate(String userRate) {
        this.userRate = userRate;
    }

    public String getUserRatePhone() {
        return userRatePhone;
    }

    public void setUserRatePhone(String userRatePhone) {
        this.userRatePhone = userRatePhone;
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

    public List<Rate> getListRate() {
        return listRate;
    }

    public void setListRate(List<Rate> listRate) {
        this.listRate = listRate;
    }

    public String getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getErrorRate() {
        return errorRate;
    }

    public List<Rate> getListRat() {
        return listRat;
    }

    public void setListRat(List<Rate> listRat) {
        this.listRat = listRat;
    }

    public void setErrorRate(String errorRate) {
        this.errorRate = errorRate;
    }

    public int getMinRate() {
        return minRate;
    }

    public void setMinRate(int minRate) {
        this.minRate = minRate;
    }

    public RateWebService_Service getService_2() {
        return service_2;
    }

    public void setService_2(RateWebService_Service service_2) {
        this.service_2 = service_2;
    }

    public int getTradingHours() {
        return tradingHours;
    }

    public void setTradingHours(int tradingHours) {
        this.tradingHours = tradingHours;
    }

    public int getIdLot() {
        return idLot;
    }

    public void setIdLot(int idLot) {
        this.idLot = idLot;
    }

    public List<Lot> getListLots() {
        return listLots;
    }

    public void setListLots(List<Lot> listLots) {
        this.listLots = listLots;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LotWebService_Service getService_1() {
        return service_1;
    }

    public void setService_1(LotWebService_Service service_1) {
        this.service_1 = service_1;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getBuyedOfUser() {
        return buyedOfUser;
    }

    public void setBuyedOfUser(String buyedOfUser) {
        this.buyedOfUser = buyedOfUser;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<ArchiveProducts> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<ArchiveProducts> listProducts) {
        this.listProducts = listProducts;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Lot> getUserLotList() {
        return userLotList;
    }

    public void setUserLotList(List<Lot> userLotList) {
        this.userLotList = userLotList;
    }

    public String getNameLot() {
        return nameLot;
    }

    public void setNameLot(String nameLot) {
        this.nameLot = nameLot;
    }

    public ArchiveWebService_Service getService() {
        return service;
    }

    public void setService(ArchiveWebService_Service service) {
        this.service = service;
    }

    public int getStartCost() {
        return startCost;
    }

    public void setStartCost(int startCost) {
        this.startCost = startCost;
    }

    public static DatatypeFactory getDf() {
        return df;
    }

    public void setLastDateRate(XMLGregorianCalendar lastDateRate) {
        this.lastDateRate = lastDateRate;
    }

    public void setIdUser(Users idUser) {
        this.idUser = idUser;
    }

    public List<client.users.Users> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<client.users.Users> listUsers) {
        this.listUsers = listUsers;
    }

    public UserWebService_Service getService_3() {
        return service_3;
    }

    public void setService_3(UserWebService_Service service_3) {
        this.service_3 = service_3;
    }

    public static void setDf(DatatypeFactory df) {
        ArchiveJSFManagedBean.df = df;
    }

    private void remove(client.lots.Lot lot) {
        client.lots.LotWebService port = service_1.getLotWebServicePort();
        port.remove(lot);
    }

    private java.util.List<client.lots.Lot> findAll() {
        client.lots.LotWebService port = service_1.getLotWebServicePort();
        return port.findAll();
    }

    private java.util.List<client.rate.Rate> findAll_3() {
        client.rate.RateWebService port = service_2.getRateWebServicePort();
        return port.findAll();
    }

    private java.util.List<client.users.Users> findAll_1() {
        client.users.UserWebService port = service_3.getUserWebServicePort();
        return port.findAll();
    }

    private Lot find(java.lang.Object id) {
        client.lots.LotWebService port = service_1.getLotWebServicePort();
        return port.find(id);
    }
}
