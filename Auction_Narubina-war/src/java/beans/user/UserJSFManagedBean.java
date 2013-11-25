/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.user;

import client.rate.RateWebService_Service;
import client.rating.RatingWebService_Service;
import client.users.Rating;
import client.users.UserWebService_Service;
import client.users.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Танюся
 */
@ManagedBean
@RequestScoped
public class UserJSFManagedBean implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/RatingWebService/RatingWebService.wsdl")
    private RatingWebService_Service service_2;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/RateWebService/RateWebService.wsdl")
    private RateWebService_Service service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/UserWebService/UserWebService.wsdl")
    private UserWebService_Service service = new UserWebService_Service();
    private List<Users> listUsers;
    private List<Users> listUser;
    private List<client.rate.Rate> listRate;
    private String fio = "";
    private String login = "";
    private String password = "";
    private String password2 = "";
    private String phoneNumber = "";
    private boolean iSAdmin = false;
    private int idUser = 0;
    private List<String> list;
    private Map<String, String> users = new HashMap<String, String>();

    /** Creates a new instance of UserJSFManagedBean */
    public UserJSFManagedBean() {
        listUsers = new ArrayList<Users>();
        listUsers = findAll();
        listUser = new ArrayList<Users>();
        for (int i = 1; i < listUsers.size(); i++) {
            listUser.add(listUsers.get(i));
        }
        for (int i = 0; i < listUsers.size(); i++) {
            users.put(listUsers.get(i).getLogin(), listUsers.get(i).getLogin());
        }
        list = new ArrayList<String>();
        
    }

    public int addNewUser() {
        if (check2()) {
            Users user = new Users();
            user.setFio(getFio());
            user.setLogin(getLogin());
            user.setPassword(getPassword());
            user.setISAdmin(isiSAdmin());
            user.setPhoneNumber(getPhoneNumber());
            user.setIDUser(1);
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("login", user.getLogin());

            FacesContext facesContext = FacesContext.getCurrentInstance();
            String redirect = "Lots-jsf.xhtml";
            NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();


            for (int i = 0; i < listUsers.size(); i++) {
                if (listUsers.get(i).getLogin().equals(login)) {
                    redirect = "falledRegistration-jsf.xhtml";
                    myNav.handleNavigation(facesContext, null, redirect);
                    return -1;
                } else if (!password.equals(password2)) {
                    redirect = "falledRegistration2-jsf.xhtml";
                    myNav.handleNavigation(facesContext, null, redirect);
                    return -1;
                }
            }
            myNav.handleNavigation(facesContext, null, redirect);
            create(user);
        }
        return 0;

    }

    public int enter() {
        Users user;
        listUsers = findAll();
        try {
            idUser = findUserByLogin();
            user = find(idUser);
        } catch (NullPointerException ex) {
            user = null;
        }
        if (check()) {
            for (int i = 0; i < listUsers.size(); i++) {
                if (listUsers.get(i).getLogin().equals(login) && listUsers.get(i).getPassword().equals(password)) {
                    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    session.setAttribute("login", user.getLogin());
                    //login = (String) session.getAttribute("login");
                    System.out.println("Login1"+login);
                    FacesContext facesContext = FacesContext.getCurrentInstance();
                    String redirect = "Lots-jsf.xhtml";
                    NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();

                    if (listUsers.get(i).isISAdmin()) {
                        redirect = "category-jsf.xhtml";
                        myNav.handleNavigation(facesContext, null, redirect);
                        return 2;
                    }
                    idUser = user.getIDUser();
                    fio = user.getFio();
                    //login=user.getLogin();
                    //password=user.getPassword();
                    phoneNumber = user.getPhoneNumber();

                    myNav.handleNavigation(facesContext, null, redirect);
                    return 0;

                }
            }
        }
        return -1;

    }

    public void sessionOut() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        session.invalidate();
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "StartPage-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);
    }

    public int findUserByLogin() {
        for (int i = 0; i < listUsers.size(); i++) {
            if (listUsers.get(i).getLogin().equals(login)) {
                return listUsers.get(i).getIDUser();
            }
        }

        return 0;
    }

    public client.rate.Users findRateByIDUser() {
        client.rate.Rate idRate;
        for (int i = 0; i < listRate.size(); i++) {
            if (listRate.get(i).getIDUser().equals(idUser)) {
                return listRate.get(i).getIDUser();
                //idRate=listRate.get(i).getIDRate();
            }
        }

        return null;
    }

    public void deleteUser() {

        Users userSel = new Users();
        for (int i = 0; i < listUser.size(); i++) {

            if (login.equals(listUser.get(i).getLogin())) {

                userSel.setLogin(listUser.get(i).getLogin());
                userSel.setIDUser(listUser.get(i).getIDUser());
                userSel.setFio(listUser.get(i).getFio());
                userSel.setPassword(listUser.get(i).getPassword());
                userSel.setPhoneNumber(listUser.get(i).getPhoneNumber());
                userSel.setISAdmin(listUser.get(i).isISAdmin());
                remove(userSel);

            }
        }

        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "category-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);
    }

    public boolean checkOfLogin() {
        if (login != null && login != "") {
            return true;
        } else {
            login = "";
            return false;
        }
    }

    public boolean checkOfPassword() {
        if (password != null && password != "") {
            return true;
        } else {
            password = "";
            return false;
        }
    }

    public boolean checkOfPhone() {

        if (phoneNumber != null && phoneNumber != "") {
            return true;
        } else {
            phoneNumber = "";
            return false;
        }
    }

    public boolean checkOfFio() {
        if (fio != null && fio != "") {
            return true;
        } else {
            login = "";
            return false;
        }
    }

    public boolean check() {
        if (checkOfLogin() && checkOfPassword()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean check2() {
        if (checkOfLogin() && checkOfPassword() && checkOfFio() && checkOfPhone()) {
            return true;
        } else {
            return false;
        }
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public boolean isiSAdmin() {
        return iSAdmin;
    }

    public void setiSAdmin(boolean iSAdmin) {
        this.iSAdmin = iSAdmin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<Users> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<Users> listUsers) {
        this.listUsers = listUsers;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public RatingWebService_Service getService_2() {
        return service_2;
    }

    public void setService_2(RatingWebService_Service service_2) {
        this.service_2 = service_2;
    }

    public List<client.rate.Rate> getListRate() {
        return listRate;
    }

    public void setListRate(List<client.rate.Rate> listRate) {
        this.listRate = listRate;
    }

    private void create(client.users.Users users) {
        client.users.UserWebService port = service.getUserWebServicePort();
        port.create(users);
    }

    private Users find(java.lang.Object id) {
        client.users.UserWebService port = service.getUserWebServicePort();
        return port.find(id);
    }

    private java.util.List<client.users.Users> findAll() {
        client.users.UserWebService port = service.getUserWebServicePort();
        return port.findAll();
    }

    public List<Users> getListUser() {
        return listUser;
    }

    public void setListUser(List<Users> listUser) {
        this.listUser = listUser;
    }

    public Map<String, String> getUsers() {
        return users;
    }

    public void setUsers(Map<String, String> users) {
        this.users = users;
    }

    private void remove(client.users.Users users) {
        client.users.UserWebService port = service.getUserWebServicePort();
        port.remove(users);
    }

    private client.rate.Rate find_1(java.lang.Object id) {
        client.rate.RateWebService port = service_1.getRateWebServicePort();
        return port.find(id);
    }

    private client.rating.Rating find_2(java.lang.Object id) {
        client.rating.RatingWebService port = service_2.getRatingWebServicePort();
        return port.find(id);
    }

    private void remove_1(client.rate.Rate rate) {
        client.rate.RateWebService port = service_1.getRateWebServicePort();
        port.remove(rate);
    }
}
