package model;

public class MatchBean {
    int id;
    String competition;
    String date;
    String season;
    int round;
    int IDhomeTeam;
    int IDawayTeam;
    int homeScore;
    int awayScore;

    String homeTeamCrest;
    String awayTeamCrest;

    public MatchBean(int id, String competition, String date, String season, int round, int IDhomeTeam, int IDawayTeam, int homeScore, int awayScore, String homeTeamCrest, String awayTeamCrest) {
        this.id = id;
        this.competition = competition;
        this.date = date;
        this.season = season;
        this.round = round;
        this.IDhomeTeam = IDhomeTeam;
        this.IDawayTeam = IDawayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.homeTeamCrest = homeTeamCrest;
        this.awayTeamCrest = awayTeamCrest;
    }
}
