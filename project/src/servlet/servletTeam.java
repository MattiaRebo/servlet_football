package servlet;

import model.SquadraBean;
import model.SquadraDAOAPI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servletTeam extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String team = req.getParameter("name");
        String competitioncode = req.getParameter("competitioncode");
        System.out.println(team);
        String crest = req.getParameter("crest");
        SquadraDAOAPI squadraDAOAPI = new SquadraDAOAPI();

        SquadraBean squadra;
        try {
            squadra = squadraDAOAPI.getTeam(team);
            squadra.setCrest(crest);
            squadra.setName(team);
            req.setAttribute("team", squadra);
            req.setAttribute("competitioncode", competitioncode);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("pages\\team.jsp").forward(req, resp);
    }
}
