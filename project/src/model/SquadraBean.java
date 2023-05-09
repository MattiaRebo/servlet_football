package model;

public class SquadraBean {
    int position;
    String name;
    String city;
    String region;
    String crest;
    int matchPlayed;
    int won;
    int lose;
    int draw;
    int point;
    int goalFor;
    int goalsAgainst;


    public SquadraBean(int position, String name, String crest, int matchPlayed, int won, int lose, int draw, int point, int goalFor, int goalsAgainst) {
        this.position = position;
        this.name = name;
        this.crest = crest;
        this.matchPlayed = matchPlayed;
        this.won = won;
        this.lose = lose;
        this.draw = draw;
        this.point = point;
        this.goalFor = goalFor;
        this.goalsAgainst = goalsAgainst;
    }

    public SquadraBean(String city, String region) {
        this.city = city;
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrest() {
        return crest;
    }

    public void setCrest(String crest) {
        this.crest = crest;
    }

    public int getMatchPlayed() {
        return matchPlayed;
    }

    public void setMatchPlayed(int matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getGoalFor() {
        return goalFor;
    }

    public void setGoalFor(int goalFor) {
        this.goalFor = goalFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }
}
