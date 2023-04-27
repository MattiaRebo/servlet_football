import model.MatchBean;
import model.MatchDAOAPI;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        MatchDAOAPI a = new MatchDAOAPI();
        ArrayList<MatchBean> test = a.getMatches(31, 2022);
    }
}