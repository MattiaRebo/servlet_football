package servlet;

import model.MatchBean;
import model.MatchDAOAPI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class servletCurrentMatch extends HttpServlet {
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {

        MatchDAOAPI m = new MatchDAOAPI();
        ArrayList<MatchBean> matchBeans;
        try {
            matchBeans = m.getCurrentMatches();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Collections.sort(matchBeans, Comparator.comparing(MatchBean::getCompetition).reversed());

        request.setAttribute("matches", matchBeans);

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
