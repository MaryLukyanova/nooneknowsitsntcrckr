package command;

import command.resource.ConfigurationManager;
import dao.DAOStones;
import dao.JDBCUtils;
import model.creator.ClassStone;
import model.myEntitys.Necklace;
import model.myEntitys.Stone;
import javax.servlet.http.HttpServletRequest;
import java.sql.Connection;
import java.util.List;


/**
 * Created by USER on 25.04.2017.
 */
public class AddStoneCommand implements ActionCommand {
    private static String NECKLACE_ATTR = "necklace";

    @Override
    public String execute(HttpServletRequest request) {

        Integer id =  Integer.parseInt(request.getParameter("stoneid"));
        String type =  request.getParameter("stonetype");

        List<Stone> stoneList = (List<Stone>) request.getSession().getAttribute(NECKLACE_ATTR);

        Connection conn = JDBCUtils.getConnectionPool().checkOut();
        Stone stone = DAOStones.getStoneById(conn, id, type);
        stoneList.add(stone);

        request.getSession().setAttribute(NECKLACE_ATTR, stoneList);

        String page = ConfigurationManager.getProperty("path.page.stones");
        return  page;
    }
}
