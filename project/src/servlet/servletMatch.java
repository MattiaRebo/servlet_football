package servlet;

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
        int matchday = 1;
        int season = 2022;
        String competizione = "SA";

        if(req.getParameter("matchday") != null){
            matchday = Integer.parseInt(req.getParameter("matchday"));
        }
        if(req.getParameter("season") != null){
            season = Integer.parseInt(req.getParameter("season"));
        }
        if(req.getParameter("competition") != null){
            competizione = req.getParameter("competition");
            System.out.println("comp: "+competizione);
        }
        MatchDAOAPI matches = new MatchDAOAPI();
        try {
            req.setAttribute("matchday", matchday);
            req.setAttribute("season", season);
            req.setAttribute("competition", competizione);
            req.setAttribute("matches", matches.getMatches(matchday, season, competizione));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher("index.jsp").forward(req, resp);

        //ArrayList<MatchBean> matches = match.getMatches();


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

