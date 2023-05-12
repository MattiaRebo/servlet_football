package model;


import dao.MatchDAO;
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
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

public class MatchDAOAPI implements MatchDAO {
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

    public String utcT0gtm(String inputDate){
        // Definisci il formato della data di input
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        // Imposta il fuso orario di input su UTC
        inputFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

        // Definisci il formato della data di output
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy' 'HH:mm:ss");
        // Imposta il fuso orario di output su GMT+2
        outputFormat.setTimeZone(TimeZone.getTimeZone("GMT+2"));

        // Data di input in formato UTC
        // Parsa la data di input
        Date date = null;
        try {
            date = inputFormat.parse(inputDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        // Formatta la data di output in GMT+2
        String outputDate = outputFormat.format(date);

        return outputDate;
    }

    public ArrayList<MatchBean> getCurrentMatches() throws IOException, InterruptedException {
        String stringRequest = "https://api.football-data.org/v4/matches?competitions=SA,PL,FL1,BL1,CL";
        HttpRequest request = requestAPI(stringRequest);
        //response
        HttpResponse<String> response = response(request);
        //response in json object
        JSONObject json = new JSONObject(response.body());

        JSONArray matchesJSON = json.getJSONArray("matches");
        ArrayList<MatchBean> matches = new ArrayList<>();

        for (int i = 0; i < matchesJSON.length(); i++){
            JSONObject Object = matchesJSON.getJSONObject(i);
            int matchID = Object.getInt("id");
            String competition = Object.getJSONObject("competition").getString("name");
            int awayTeamID = Object.getJSONObject("awayTeam").getInt("id");
            int homeTeamID = Object.getJSONObject("homeTeam").getInt("id");
            String awayTeam = Object.getJSONObject("awayTeam").getString("shortName");
            String homeTeam = Object.getJSONObject("homeTeam").getString("shortName");
            String awayTeamCrest = Object.getJSONObject("awayTeam").getString("crest");
            String homeTeamCrest = Object.getJSONObject("homeTeam").getString("crest");
            String date = utcT0gtm(Object.getString("utcDate")).substring(11,16);
            String status = Object.getString("status");
            int awayScore = 0;
            int homeScore = 0;
            if(Objects.equals(status, "FINISHED") || Objects.equals(status, "IN_PLAY") || Objects.equals(status, "PAUSED")){
                awayScore = Object.getJSONObject("score").getJSONObject("fullTime").getInt("away");
                homeScore = Object.getJSONObject("score").getJSONObject("fullTime").getInt("home");
            }

            switch (status) {
                case "FINISHED" -> status = "FINITA";
                case "IN_PLAY" -> status = "RISULTATO IN DIRETTA";
                case "PAUSED" -> status = "FINE 1° TEMPO";
                case "TIMED", "SCHEDULED" -> status = "DA GIOCARE";
                case "POSTPONED" -> status = "POSTICIPATA";
                case "CANCELLED" -> status = "CANCELLATA";
            }
            MatchBean match = new MatchBean(matchID, date, homeTeamID, awayTeamID, homeTeam, awayTeam, homeScore, awayScore, homeTeamCrest, awayTeamCrest, status, competition);
            matches.add(match);
        }
        return matches;
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
            String awayTeam = Object.getJSONObject("awayTeam").getString("shortName");
            String homeTeam = Object.getJSONObject("homeTeam").getString("shortName");
            String awayTeamCrest = Object.getJSONObject("awayTeam").getString("crest");
            String homeTeamCrest = Object.getJSONObject("homeTeam").getString("crest");
            String date = utcT0gtm(Object.getString("utcDate")).substring(0,16);
            String status = Object.getString("status");
            int awayScore = 0;
            int homeScore = 0;
            if(Objects.equals(status, "FINISHED") || Objects.equals(status, "IN_PLAY") || Objects.equals(status, "PAUSED")){
                awayScore = Object.getJSONObject("score").getJSONObject("fullTime").getInt("away");
                homeScore = Object.getJSONObject("score").getJSONObject("fullTime").getInt("home");
            }

            switch (status) {
                case "FINISHED" -> status = "FINITA";
                case "IN_PLAY" -> status = "RISULTATO IN DIRETTA";
                case "PAUSED" -> status = "FINE 1° TEMPO";
                case "TIMED", "SCHEDULED" -> status = "DA GIOCARE";
                case "POSTPONED" -> status = "POSTICIPATA";
                case "CANCELLED" -> status = "CANCELLATA";
            }


            MatchBean match = new MatchBean(matchID, date, season, matchday, homeTeamID, awayTeamID, homeTeam, awayTeam, homeScore, awayScore, homeTeamCrest, awayTeamCrest, status);
            match.setAwayTeamNoSpace(awayTeam.replace(" ", "+"));
            System.out.println(match.getAwayTeamNoSpace());
            match.setHomeTeamNoSpace(homeTeam.replace(" ", "+"));
            matches.add(match);
        }


        /*System.out.println(json);

        System.out.println(matches.size());
        System.out.println(matches.get(6).getHomeTeam() +"- "+matches.get(6).getAwayTeam());
        */
        return matches;
    }
}
