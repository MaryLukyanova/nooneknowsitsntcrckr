package servlets;

import model.creator.ClassStone;
import model.myEntitys.Necklace;
import model.myEntitys.Stone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by USER on 02.04.2017.
 */
@WebServlet(urlPatterns = "/stones", loadOnStartup = 1)
public class StoneServlet extends HttpServlet {

    public static final String INPUT_FILE_NAME = "C:\\Users\\USER\\IdeaProjects\\netcr_servlets_JDBS\\input.txt";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Necklace necklace = getNecklaceFromFile();
        ArrayList<Stone> stones = necklace.getNecklace();

        request.setAttribute("stones", stones);
        request.getRequestDispatcher("stones.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        super.doPost(request, response);
    }


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

}
