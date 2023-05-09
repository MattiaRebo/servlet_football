import model.*;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        SquadraDAOAPI squadraDAOAPI = new SquadraDAOAPI();

        SquadraBean squadra = squadraDAOAPI.getTeam("napoli");
        System.out.println(squadra.getRegion());
    }
}