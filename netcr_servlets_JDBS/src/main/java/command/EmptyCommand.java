package command;
import command.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements ActionCommand {
   @Override
   public String execute(HttpServletRequest request) {
    /* в случае ошибки или прямого обращения к контроллеру
     * переадресация на страницу */
      String page = ConfigurationManager. getProperty("path.page.stones");
      return page;
   }
}