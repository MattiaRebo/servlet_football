package servlet;

import model.MatchDAOAPI;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

public class servletCurrentMatch extends HttpServlet {
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {

        MatchDAOAPI m = new MatchDAOAPI();

        try {
            request.setAttribute("matches", m.getCurrentMatches());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("currentMatch.jsp").forward(request, response);

    }
}
