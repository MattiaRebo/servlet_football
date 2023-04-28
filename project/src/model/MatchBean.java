package model;

public class MatchBean {
    int id;
    String date;
    int season;
    int round;
    int IDhomeTeam;
    String homeTeam;
    String awayTeam;
    int IDawayTeam;
    int homeScore;
    int awayScore;
    String status;

    String homeTeamCrest;
    String awayTeamCrest;

    public MatchBean(int id, String date, int season, int round, int IDhomeTeam, int IDawayTeam, String homeTeam, String awayTeam, int homeScore, int awayScore, String homeTeamCrest, String awayTeamCrest, String status) {
        this.id = id;
        this.date = date;
        this.season = season;
        this.round = round;
        this.IDhomeTeam = IDhomeTeam;
        this.IDawayTeam = IDawayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.homeTeamCrest = homeTeamCrest;
        this.awayTeamCrest = awayTeamCrest;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getIDhomeTeam() {
        return IDhomeTeam;
    }

    public void setIDhomeTeam(int IDhomeTeam) {
        this.IDhomeTeam = IDhomeTeam;
    }

    public int getIDawayTeam() {
        return IDawayTeam;
    }

    public void setIDawayTeam(int IDawayTeam) {
        this.IDawayTeam = IDawayTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getHomeTeamCrest() {
        return homeTeamCrest;
    }

    public void setHomeTeamCrest(String homeTeamCrest) {
        this.homeTeamCrest = homeTeamCrest;
    }

    public String getAwayTeamCrest() {
        return awayTeamCrest;
    }

    public void setAwayTeamCrest(String awayTeamCrest) {
        this.awayTeamCrest = awayTeamCrest;
    }
}
