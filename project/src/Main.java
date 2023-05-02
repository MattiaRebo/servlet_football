import model.MatchBean;
import model.MatchDAOAPI;
import model.standingDAOAPI;
import model.standingsBean;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        standingsBean classi = new standingsBean();
        standingDAOAPI classifica = new standingDAOAPI();

        System.out.println(classifica.getStanding(2022, "SA", classi));
    }
}