/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.ArchiveProducts;
import entity.Lot;
import facade.ArchiveProductsFacadeLocal;
import facade.LotFacadeLocal;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Танюся
 */
public class SessionLogicArchive extends SessionLogicLot{
    @EJB
    private ArchiveProductsFacadeLocal archiveFacade;
    @EJB
    private LotFacadeLocal lotFacade;
    
     public int addInArchive(String nameLot, int startCost, String idUser, String loginUser) {
        Date date = new Date();
        ArchiveProducts archive = new ArchiveProducts();
        int idLot = findLotByName(nameLot);
        Lot lot = lotFacade.find(this.findLotByName(nameLot));
        archive.setAddedDate(date);
        archive.setBuyedOfUser(idUser);
        archive.setIDProduct(idLot);
        archive.setIDUser(null);
        archive.setNameLot(nameLot);
        archive.setStartCost(startCost);
        archive.setLastDateRate(date);
        archiveFacade.create(archive);
        return 0;
    }
    
}
