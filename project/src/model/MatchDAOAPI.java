package model;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class MatchDAOAPI {
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

    public ArrayList<MatchBean> getMatches(int matchday, int season) throws IOException, InterruptedException {
        String stringRequest = "https://api.football-data.org/v4/competitions/SA/matches?matchday="+matchday+"&season="+season;
        //request
        HttpRequest request = requestAPI(stringRequest);
        //response
        HttpResponse<String> response = response(request);
        //response in json object
        JSONObject json = new JSONObject(response.body());
        //Array daily matches
        JSONArray matchesJSON = json.getJSONArray("matches");

        ArrayList<MatchBean> matches = new ArrayList<>();

        for (int i = 0; i < matchesJSON.length(); i++){
            JSONObject Object = matchesJSON.getJSONObject(i);
            int matchID = Object.getInt("id");

            int awayTeamID = Object.getJSONObject("awayTeam").getInt("id");
            int homeTeamID = Object.getJSONObject("homeTeam").getInt("id");
            String awayTeam = Object.getJSONObject("awayTeam").getString("name");
            String homeTeam = Object.getJSONObject("homeTeam").getString("name");
            String awayTeamCrest = Object.getJSONObject("awayTeam").getString("crest");
            String homeTeamCrest = Object.getJSONObject("homeTeam").getString("crest");
            String date = Object.getString("utcDate");
            int awayScore = Object.getJSONObject("score").getJSONObject("fullTime").getInt("away");
            int homeScore = Object.getJSONObject("score").getJSONObject("fullTime").getInt("home");

            MatchBean match = new MatchBean(matchID, date, season, matchday, homeTeamID, awayTeamID, homeTeam, awayTeam, homeScore, awayScore, homeTeamCrest, awayTeamCrest);
            matches.add(match);
        }


        /*System.out.println(json);

        System.out.println(matches.size());
        System.out.println(matches.get(6).getHomeTeam() +"- "+matches.get(6).getAwayTeam());
        */
        return matches;
    }
}
