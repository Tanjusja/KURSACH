/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Category;
import facade.CategoryFacadeLocal;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Танюся
 */
public class SessionLogicCategory extends SessionLogicLot{

    @EJB
    private CategoryFacadeLocal categoryFacade;

    public List<Category> getAllCategorys() {

        List<Category> list = categoryFacade.findAll();
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
     public int addCategory(String nameCategory) {
        List<Category> list = categoryFacade.findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNameCategory().equals(nameCategory)) {
                return -1;
            }
        }
        Category category = new Category();
        category.setNameCategory(nameCategory);
        categoryFacade.create(category);
        return 0;
    }

    public void delleteCategory(int idCategory) {
        categoryFacade.remove(categoryFacade.find(idCategory));
    }
}
