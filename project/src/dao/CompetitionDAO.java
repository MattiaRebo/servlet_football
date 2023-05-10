package dao;

import model.CompetitionBean;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public interface CompetitionDAO {
    HttpRequest requestAPI(String request);
    HttpResponse<String> response(HttpRequest request) throws IOException, InterruptedException;
    CompetitionBean getCompetition(String compcode) throws IOException, InterruptedException;
}
