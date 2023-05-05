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
        String competition = req.getParameter("competitions");
        String emblem = req.getParameter("emblem");
        String competitioncode = req.getParameter("competitioncode");
        int matchday = Integer.parseInt(req.getParameter("matchday"));
        int season = Integer.parseInt(req.getParameter("season"));

        standingDAOAPI standingDAO = new standingDAOAPI();

        try {
            standingsBean classifica = new standingsBean(standingDAO.getStanding(competitioncode));

            req.setAttribute("matchday", matchday);
            req.setAttribute("season", season);
            req.setAttribute("competitioncode", competitioncode);
            req.setAttribute("comp", competition);
            req.setAttribute("emblem", emblem);
            req.setAttribute("classifica", classifica.getClassifica());

        } catch (InterruptedException | ParseException e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("pages\\classifica.jsp").forward(req, resp);
    }
}
