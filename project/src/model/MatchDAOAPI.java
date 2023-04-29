package model;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Objects;

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

    public ArrayList<MatchBean> getMatches(int matchday, int season, String comp) throws IOException, InterruptedException {
        String stringRequest = "https://api.football-data.org/v4/competitions/"+comp+"/matches?matchday="+matchday+"&season="+season;
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
            String status = Object.getString("status");
            int awayScore = 0;
            int homeScore = 0;
            if(Objects.equals(status, "FINISHED") || Objects.equals(status, "IN_PLAY") || Objects.equals(status, "PAUSED")){
                awayScore = Object.getJSONObject("score").getJSONObject("fullTime").getInt("away");
                homeScore = Object.getJSONObject("score").getJSONObject("fullTime").getInt("home");
            }

            switch (status) {
                case "FINISHED" -> status = "FINITA";
                case "IN_PLAY" -> status = "IN GIOCO";
                case "PAUSED" -> status = "IN PAUSA";
                case "TIMED", "SCHEDULED" -> status = "DA GIOCARE";
                case "POSTPONED" -> status = "POSTICIPATA";
                case "CANCELLED" -> status = "CANCELLATA";
            }


            MatchBean match = new MatchBean(matchID, date, season, matchday, homeTeamID, awayTeamID, homeTeam, awayTeam, homeScore, awayScore, homeTeamCrest, awayTeamCrest, status);
            matches.add(match);
        }


        /*System.out.println(json);

        System.out.println(matches.size());
        System.out.println(matches.get(6).getHomeTeam() +"- "+matches.get(6).getAwayTeam());
        */
        return matches;
    }
}
