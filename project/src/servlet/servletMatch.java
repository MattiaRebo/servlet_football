package servlet;

import model.CompetitionBean;
import model.MatchBean;
import model.MatchDAOAPI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class servletMatch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String competition = req.getParameter("competitions");
        String emblem = req.getParameter("emblem");
        String competitioncode = req.getParameter("competitioncode");
        int matchday = Integer.parseInt(req.getParameter("matchday"));
        int season = Integer.parseInt(req.getParameter("season"));

        MatchDAOAPI matches = new MatchDAOAPI();
        try {
            req.setAttribute("matchday", matchday);
            req.setAttribute("season", season);
            req.setAttribute("competitioncode", competitioncode);
            req.setAttribute("comp", competition);
            req.setAttribute("emblem", emblem);
            req.setAttribute("matches", matches.getMatches(matchday, season, competitioncode));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("pages\\matches.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

