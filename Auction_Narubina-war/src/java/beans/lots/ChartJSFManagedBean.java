/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans.lots;

import client.lots.Lot;
import client.lots.LotWebService_Service;
import client.rate.Rate;
import client.rate.RateWebService_Service;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.WebServiceRef;
import org.primefaces.model.chart.CartesianChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Танюся
 */
@ManagedBean
@RequestScoped
public class ChartJSFManagedBean implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/RateWebService/RateWebService.wsdl")
    private RateWebService_Service service_1 = new RateWebService_Service();
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/LotWebService/LotWebService.wsdl")
    private LotWebService_Service service = new LotWebService_Service();
    private CartesianChartModel categoryModel;
    private int tempSumm;
    private String nameLot = "";
    private int startCost = 0;
    private int amountRate = 0;
    private List<Lot> listLots;
    private List<Rate> listRate;

    /** Creates a new instance of ChartJSFManagedBean */
    public ChartJSFManagedBean() {
        createCategoryModel();
        listLots = new ArrayList<Lot>();
        listLots=findAll_1();

        listRate = new ArrayList<Rate>();
        listRate = findAll();
    }

    public CartesianChartModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CartesianChartModel categoryModel) {
        this.categoryModel = Singleton.getCategoryModel();
    }

    public int getTempSumm() {
        return tempSumm;
    }

    public void setTempSumm(int tempSumm) {
        this.tempSumm = tempSumm;
    }

    private void createCategoryModel() {
        categoryModel = new CartesianChartModel();
        ChartSeries cost = new ChartSeries();
        ChartSeries rate = new ChartSeries();
        cost.setLabel("Цена");
        rate.setLabel("Ставка");
        double[] mass;
        double[] Mass;
        
        listRate = findAll();
        if (!listRate.isEmpty()) {
            for (int i = 0; i < listRate.size(); i++) {

                startCost=listRate.get(i).getIDLot().getStartCost();
                amountRate=listRate.get(i).getAmountRate();
                int result=amountRate-startCost;
                    cost.set(listRate.get(i).getIDLot().getNameLot(),listRate.get(i).getIDLot().getStartCost());
                    rate.set(listRate.get(i).getIDLot().getNameLot(),result);
                }
            }
         else {
            System.out.println("IS EMPTY!((((((((((((((((((((((((");
        }
        
        mass = generateValues();
        Mass = myTrend(mass);

        categoryModel.addSeries(cost);
        categoryModel.addSeries(rate);

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

    private java.util.List<client.rate.Rate> findAll() {
        client.rate.RateWebService port = service_1.getRateWebServicePort();
        return port.findAll();
    }

    private java.util.List<client.lots.Lot> findAll_1() {
        client.lots.LotWebService port = service.getLotWebServicePort();
        return port.findAll();
    }
}
