package model;


import dao.SquadraDAO;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.ParseException;
import java.util.ArrayList;

public class SquadraDAOAPI implements SquadraDAO {
    private static final String API_KEY = "6aa0297c2bf5461eb299dd08f42e859e";

    private static HttpRequest requestAPI(String request){

        return HttpRequest.newBuilder()
                .uri(URI.create(request))
                .header("x-auth-token", API_KEY)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
    }

    public static HttpResponse<String> response(HttpRequest request) throws IOException, InterruptedException {
        return HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

    }

    public SquadraBean getTeam(String team) throws IOException, InterruptedException {
        String stringRequest = "http://localhost:9111/squadra/"+team;
        HttpRequest request = requestAPI(stringRequest);
        HttpResponse<String> response = response(request);
        System.out.println(response);
        JSONObject json = new JSONObject(response.body());

        String region = json.getString("region");
        String city = json.getString("city");

        return new SquadraBean(city, region);
    }

    public ArrayList<SquadraBean> getStanding(String comp) throws IOException, InterruptedException, ParseException {
        String stringRequest = "https://api.football-data.org/v4/competitions/"+comp+"/standings";
        //request
        HttpRequest request = requestAPI(stringRequest);
        //response
        HttpResponse<String> response = response(request);
        //response in json object
        JSONObject json = new JSONObject(response.body());

        JSONArray table = json.getJSONArray("standings").getJSONObject(0).getJSONArray("table");
        ArrayList<SquadraBean> squadre = new ArrayList<>();

        for (int i = 0; i < table.length(); i++){
            JSONObject Object = table.getJSONObject(i);

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
}
