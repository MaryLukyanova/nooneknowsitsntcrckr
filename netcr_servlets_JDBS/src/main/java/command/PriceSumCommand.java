package command;

import command.resource.ConfigurationManager;
import model.myEntitys.Necklace;
import model.myEntitys.Stone;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by USER on 28.04.2017.
 */
public class PriceSumCommand implements ActionCommand {
    private static String NECKLACE_ATTR = "necklace";

    @Override
    public String execute(HttpServletRequest request) {

        List<Stone> stoneList = (List<Stone>) request.getSession().getAttribute(NECKLACE_ATTR);
        Necklace necklace = new Necklace(stoneList);

        Double priceSum = necklace.getNecklacePrice();

        request.getSession().setAttribute("priceSum", priceSum);

        String page = ConfigurationManager.getProperty("path.page.necklace");
        return  page;
    }
}
