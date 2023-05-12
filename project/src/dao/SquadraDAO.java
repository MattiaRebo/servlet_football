package dao;

import model.SquadraBean;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public interface SquadraDAO {
    ArrayList<SquadraBean> getStanding(String comp, int season) throws IOException, InterruptedException, ParseException;
    SquadraBean getTeam(String team) throws IOException, InterruptedException, ParseException;
}
