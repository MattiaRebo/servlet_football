import model.MatchBean;
import model.MatchDAOAPI;
import model.standingsBean;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        String dateInString = "2023-05-05T18:30:00Z";
        String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
        LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));

        ZoneId singaporeZoneId = ZoneId.of("Asia/Singapore");
        System.out.println("TimeZone : " + singaporeZoneId);

    }
}