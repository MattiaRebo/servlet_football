package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import model.SquadraBean;
import model.standingDAOAPI;
import model.standingsBean;

public class servletClassifica extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comp = req.getParameter("comp");
        int season = Integer.parseInt(req.getParameter("season"));

        standingsBean classifica = new standingsBean();
        standingDAOAPI dao = new standingDAOAPI();

        try {
            ArrayList<SquadraBean> squadre = dao.getStanding(season, comp, classifica);

            req.setAttribute("classifica", classifica);
            req.setAttribute("squadre", squadre);
            req.setAttribute("comp", comp);
            req.getRequestDispatcher("pages\\classifica.html").forward(req, resp);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
}
