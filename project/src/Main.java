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

        MatchDAOAPI matchDAOAPI = new MatchDAOAPI();
        ArrayList<MatchBean> matches = matchDAOAPI.getCurrentMatches();

        Collections.sort(matches, Comparator.comparing(MatchBean::getCompetition).reversed());
        for (int i = 0; i < matches.size(); i++){
            System.out.println(matches.get(i).getCompetition());
        }

    }
}