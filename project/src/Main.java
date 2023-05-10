import model.*;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        SquadraDAOAPI squadraDAOAPI = new SquadraDAOAPI();

        SquadraBean squadra = squadraDAOAPI.getTeam("napoli");
        System.out.println(squadra.getRegion());
    }
}