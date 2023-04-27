package model;


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

    public ArrayList<MatchBean> getMatches() throws IOException, InterruptedException {
        String stringRequest = "https://api.football-data.org/v4/competitions/SA/matches?matchday=31";
        HttpRequest request = requestAPI(stringRequest);
        HttpResponse<String> response = response(request);

        JSONObject json = new JSONObject(response.body());
        String js = response.body();

        ArrayList<MatchBean> matches = new ArrayList<>();

        return matches;
    }
}
