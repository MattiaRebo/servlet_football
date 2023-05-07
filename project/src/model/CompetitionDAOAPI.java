package model;

import dao.CompetitionDAO;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CompetitionDAOAPI implements CompetitionDAO {

    private static final String API_KEY = "6aa0297c2bf5461eb299dd08f42e859e";

    public HttpRequest requestAPI(String request){

        return HttpRequest.newBuilder()
                .uri(URI.create(request))
                .header("x-auth-token", API_KEY)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
    }

    public HttpResponse<String> response(HttpRequest request) throws IOException, InterruptedException {
        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

    }

    public CompetitionBean getCompetition(String compcode) throws IOException, InterruptedException {
        String stringRequest = "https://api.football-data.org/v4/competitions/"+compcode;
        HttpRequest request = requestAPI(stringRequest);
        HttpResponse<String> response = response(request);

        JSONObject json = new JSONObject(response.body());
        String competition = json.getString("name");
        String competitionCode = json.getString("code");
        String emblem = json.getString("emblem");
        String paese =  json.getJSONObject("area").getString("name");
        int year = Integer.parseInt(json.getJSONObject("currentSeason").getString("startDate").substring(0, 4));
        String season = year + "/" + year+1;
        int currentMatchday = json.getJSONObject("currentSeason").getInt("currentMatchday");
        String startDate = json.getJSONObject("currentSeason").getString("startDate");
        String endDate = json.getJSONObject("currentSeason").getString("endDate");

        return new CompetitionBean(competition, competitionCode, paese, emblem, year, season, currentMatchday, startDate, endDate);
    }


}
