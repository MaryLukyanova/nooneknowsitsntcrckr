package servlets;

import command.ActionCommand;
import command.factory.ActionFactory;
import command.resource.ConfigurationManager;
import dao.DAOStones;
import dao.JDBCUtils;
import model.creator.ClassStone;
import model.myEntitys.Necklace;
import model.myEntitys.Stone;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.sql.Connection;

/**
 * Created by USER on 02.04.2017.
 */
@WebServlet(urlPatterns = "/stones", loadOnStartup = 1)
public class StoneServlet extends HttpServlet {

    private static Necklace necklace;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Connection conn = JDBCUtils.getConnectionPool().checkOut();
        necklace = new Necklace();

        HttpSession session = request.getSession(true);
        session.setAttribute("gems", DAOStones.getGems(conn));
        session.setAttribute("semiprecious", DAOStones.getSemiprecious(conn));
        JDBCUtils.getConnectionPool().checkIn(conn);

      //HttpSession session = request.getSession(true);
        if (session.getAttribute("necklace") == null) {
            session.setAttribute("necklace", necklace.getNecklace());
        }

        request.getRequestDispatcher("stones.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        // определение команды, пришедшей из JSP
        ActionFactory client = new ActionFactory();
        ActionCommand command = client.defineCommand(request);
    /*
     * вызов реализованного метода execute() и передача параметров
     * классу-обработчику конкретной команды
     */
        page = command.execute(request);
        // метод возвращает страницу ответа
        // page = null; // поэксперементировать!
        if (page != null) {
           RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
            // вызов страницы ответа на запрос
            dispatcher.forward(request, response);
          //  response.sendRedirect("/stones.jsp");
        } else {
            // установка страницы c cообщением об ошибке
            page = ConfigurationManager.getProperty("path.page.stones");
            request.getSession().setAttribute("nullPage", "Page not found. Business logic error.");
            response.sendRedirect(request.getContextPath() + page);
        }
    }

    /*  public static final String INPUT_FILE_NAME = "C:\\Users\\USER\\IdeaProjects\\netcr_servlets_JDBS\\input.txt";
    public static Necklace getNecklaceFromFile(){
        Necklace necklace = new Necklace();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(INPUT_FILE_NAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNext())
        {
            String line = scanner.nextLine();
            String[] string = line.split("[ \r\n]");
            Stone stone = ClassStone.createStone(string[0], string[1], Double.valueOf(string[2]));
            necklace.addStone(stone);
        }

        scanner.close();
        return  necklace;
    }
  */
}
