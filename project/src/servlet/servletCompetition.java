package servlet;

import model.CompetitionBean;
import model.CompetitionDAOAPI;

import javax.servlet.http.HttpServlet;


public class servletCompetition extends HttpServlet {
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException {
        String comp = req.getParameter("competition");

        CompetitionDAOAPI p = new CompetitionDAOAPI();
        try {
            CompetitionBean cbean = p.getCompetition(comp);
            req.setAttribute("comp", cbean);
            req.getRequestDispatcher("pages\\competition.jsp").forward(req, resp);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException, java.io.IOException {
        doGet(req, resp);
    }
}
