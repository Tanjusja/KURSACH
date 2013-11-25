/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import entity.Comments;
import entity.Lot;
import facade.CommentsFacadeLocal;
import facade.LotFacadeLocal;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Танюся
 */
public class SessionLogicComments extends SessionLogicLot{

    @EJB
    private CommentsFacadeLocal commentsFacade;
    @EJB
    private LotFacadeLocal lotFacade;

    public List<Comments> getAllComments() {

        List<Comments> list = commentsFacade.findAll();
        return list;
    }

    public int addComments(String description, String nameLot) {
        List<Comments> list = commentsFacade.findAll();
        Lot lot = lotFacade.find(this.findLotByName(nameLot));
        Comments comments = new Comments();
        comments.setIDLot(lot);
        comments.setDescription(description);
        commentsFacade.create(comments);
        return 0;
    }

    public void delleteComments(int idComments) {
        commentsFacade.remove(commentsFacade.find(idComments));
    }
}
