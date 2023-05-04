package model;

public class CompetitionBean {
    String competition;
    String competitioncode;
    String area;
    String emblem;
    int year;
    String season;
    int currentMatchday;
    String startDate;
    String  endDate;

    public CompetitionBean(String competition, String competitioncode, String area, String emblem, int year, String season, int currentMatchday, String startDate, String endDate) {
        this.competition = competition;
        this.competitioncode = competitioncode;
        this.area = area;
        this.emblem = emblem;
        this.year = year;
        this.season = season;
        this.currentMatchday = currentMatchday;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CompetitionBean() {
    }

    public String getCompetition() {
        return competition;
    }

    public String getCompetitioncode() {
        return competitioncode;
    }

    public void setCompetitioncode(String competitioncode) {
        this.competitioncode = competitioncode;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public int getCurrentMatchday() {
        return currentMatchday;
    }

    public void setCurrentMatchday(int currentMatchday) {
        this.currentMatchday = currentMatchday;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
