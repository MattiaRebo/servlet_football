package dao;

import model.MatchBean;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public interface MatchDAO {
    HttpRequest requestAPI(String request);
    HttpResponse<String> response(HttpRequest request) throws IOException, InterruptedException;
    ArrayList<MatchBean> getCurrentMatches() throws IOException, InterruptedException;
    String utcT0gtm(String inputDate);
    ArrayList<MatchBean> getMatches(int matchday, int season, String comp) throws IOException, InterruptedException;

}
