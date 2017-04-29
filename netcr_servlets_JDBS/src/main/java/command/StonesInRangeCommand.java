package command;

import command.resource.ConfigurationManager;
import model.myEntitys.Necklace;
import model.myEntitys.Stone;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by USER on 28.04.2017.
 */
public class StonesInRangeCommand implements ActionCommand {
    private static String NECKLACE_ATTR = "necklace";

    @Override
    public String execute(HttpServletRequest request) {
        int a=0, b=0;

        if(request.getParameter("a")!="" && request.getParameter("b")!="") {
            a = Integer.parseInt(request.getParameter("a"));
            b = Integer.parseInt(request.getParameter("b"));
        }
        else {
            request.setAttribute("invalidNumbers", "INVALID VALUES. Values should be >=0");
            String page = ConfigurationManager.getProperty("path.page.necklace");
            return  page;
        }

        List<Stone> stoneList = (List<Stone>) request.getSession().getAttribute(NECKLACE_ATTR);
        Necklace necklace = new Necklace(stoneList);

        if(a>=0 && b>=0 && b>=a) {
            stoneList = necklace.findStonesInCaratRange(a, b);
            request.getSession().setAttribute("rangeStones", stoneList);
        }
        else request.setAttribute("invalidNumbers", "INVALID VALUES. Values should be >=0");

        String page = ConfigurationManager.getProperty("path.page.necklace");
        return  page;
    }
}
