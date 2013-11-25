/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.lots;

import org.primefaces.model.chart.CartesianChartModel;

/**
 *
 * @author Танюся
 */
public class Singleton {

    public static CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    public static void setCategoryModel(CartesianChartModel categoryModel) {
        Singleton.categoryModel = categoryModel;
    }
    private static Singleton instance;
    private static CartesianChartModel categoryModel;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
