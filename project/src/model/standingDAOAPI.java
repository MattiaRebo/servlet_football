/*package model;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;

public class standingDAOAPI {
    private static final String API_KEY = "6aa0297c2bf5461eb299dd08f42e859e";

    private HttpRequest requestAPI(String request){

        return HttpRequest.newBuilder()
                .uri(URI.create(request))
                .header("x-auth-token", API_KEY)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
    }

    public HttpResponse<String> response(HttpRequest request) throws IOException, InterruptedException {
        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

    }

    public ArrayList<SquadraBean> getStanding(int season, String comp, standingsBean standing) throws IOException, InterruptedException, ParseException {
        String stringRequest = "https://api.football-data.org/v4/competitions/"+comp+"/standings?season="+season;
        //request
        HttpRequest request = requestAPI(stringRequest);
        //response
        HttpResponse<String> response = response(request);
        //response in json object
        JSONObject json = new JSONObject(response.body());

        standing.setCompetition(json.getJSONObject("competition").getString("name"));
        String stagione = season + "/" + season+1;
        System.out.println(json.toString(4));
        standing.setYear(stagione);
        standing.setEmblem(json.getJSONObject("competition").getString("emblem"));
        standing.setStartDate(json.getJSONObject("season").getString("startDate"));
        standing.setEndDate(json.getJSONObject("season").getString("endDate"));
        standing.setCurrentMatchday(json.getJSONObject("season").getInt("currentMatchday"));
        standing.setArea(json.getJSONObject("area").getString("name"));

        JSONArray classifica = json.getJSONArray("standings").getJSONObject(1).getJSONArray("table");
        ArrayList<SquadraBean> squadre = new ArrayList<>();

        for (int i = 0; i < classifica.length(); i++){
            JSONObject Object = classifica.getJSONObject(i);

            int position = Object.getInt("position");
            String name = Object.getJSONObject("team").getString("shortName");
            String crest = Object.getJSONObject("team").getString("crest");
            int matchPlayed = Object.getInt("playedGames");
            int won = Object.getInt("won");
            int draw = Object.getInt("draw");
            int lose = Object.getInt("lost");
            int points = Object.getInt("points");
            int goalFor = Object.getInt("goalsFor");
            int goalsAgainst = Object.getInt("goalsAgainst");

            SquadraBean squadra = new SquadraBean(position, name, crest, matchPlayed, won, lose, draw, points, goalFor, goalsAgainst);

            squadre.add(squadra);
        }
        return squadre;
    }
}*/
