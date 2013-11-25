/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.category;

import client.category.Category;
import client.category.CategoryWebService_Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Танюся
 */
@ManagedBean
@RequestScoped
public class CategoryJSFManagedBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CategoryWebService/CategoryWebService.wsdl")
    private CategoryWebService_Service service = new CategoryWebService_Service();
    private List<Category> listCategory;
    private List<Category> listCategories;
    private int idCategory = 0;
    private String nameCategory = "";
    private List<String> list;
    private Map<String, String> categories = new HashMap<String, String>();

    /** Creates a new instance of CategoryJSFManagedBean */
    public CategoryJSFManagedBean() {
        listCategory = new ArrayList<Category>();
        listCategory = findAll();
        listCategories = new ArrayList<Category>();
        for (int i = 1; i < listCategory.size(); i++) {
            listCategories.add(listCategory.get(i));
        }
        for (int i = 0; i < listCategory.size(); i++) {
            categories.put(listCategory.get(i).getNameCategory(), listCategory.get(i).getNameCategory());
        }
        list = new ArrayList<String>();

    }

    public void list() {
        for (int i = 0; i < listCategory.size(); i++) {
            list.add(listCategory.get(i).getNameCategory());
            nameCategory = list.get(i);
        }
    }

    public int addNewCategory() {

        Category category = new Category();
        category.setIDCategory(1);
        category.setNameCategory(getNameCategory());

        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "category-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        
        for (int i = 0; i < listCategory.size(); i++) {
            if (listCategory.get(i).getNameCategory().equals(nameCategory)) {
                return -1;
            }
        }   
        create(category);
        myNav.handleNavigation(facesContext, null, redirect);
        return 0;
    }

//    public int findCategoryByName(String nameCategory) {
//        listCategory = findAll();
//        for (int i = 0; i < list.size(); i++) {
//            if (listCategory.get(i).getNameCategory().equals(nameCategory)) {
//                return listCategory.get(i).getIDCategory();
//            }
//        }
//        return 0;
//    }
//    public SelectItem getNameItem(){
//        return new SelectItem(nameCategory);
//        
//    }
    public void deleteCategory() {

        Category categorySel = new Category();
        for (int i = 0; i < listCategories.size(); i++) {

            if (nameCategory.equals(listCategories.get(i).getNameCategory())) {

                categorySel.setNameCategory(listCategories.get(i).getNameCategory());
                categorySel.setIDCategory(listCategories.get(i).getIDCategory());
                remove(categorySel);
   
            }
        }
        //getNameItem();
        //idCategory=findCategoryByName(nameCategory);

//        list = new ArrayList<String>();
//        for (int i = 0; i < listCategories.size(); i++) {
//            list.remove(listCategories.get(i).getNameCategory());
//            nameCategory = list.get(i);
//        }
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String redirect = "category-jsf.xhtml";
        NavigationHandler myNav = facesContext.getApplication().getNavigationHandler();
        myNav.handleNavigation(facesContext, null, redirect);
    }

    private java.util.List<client.category.Category> findAll() {
        client.category.CategoryWebService port = service.getCategoryWebServicePort();
        return port.findAll();
    }

    private void create(client.category.Category category) {
        client.category.CategoryWebService port = service.getCategoryWebServicePort();
        port.create(category);
    }

    private void remove(client.category.Category category) {
        client.category.CategoryWebService port = service.getCategoryWebServicePort();
        port.remove(category);
    }

    private Category find(java.lang.Object id) {
        client.category.CategoryWebService port = service.getCategoryWebServicePort();
        return port.find(id);
    }
    public List<Category> getListCategories() {
        return listCategories;
    }

    public void setListCategories(List<Category> listCategories) {
        this.listCategories = listCategories;
    }

    public Map<String, String> getCategories() {
        return categories;
    }

    public void setCategories(Map<String, String> categories) {
        this.categories = categories;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<Category> getListCategory() {
        return listCategory;
    }

    public void setListCategory(List<Category> listCategory) {
        this.listCategory = listCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public CategoryWebService_Service getService() {
        return service;
    }

    public void setService(CategoryWebService_Service service) {
        this.service = service;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }
}
