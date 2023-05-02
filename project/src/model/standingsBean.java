package model;

import java.util.ArrayList;
import java.util.Date;

public class standingsBean {
    ArrayList<SquadraBean> standings = new ArrayList<>(20);
    String competition;
    String area;
    String emblem;
    String year;
    int currentMatchday;
    String startDate;
    String  endDate;

    public standingsBean(ArrayList<SquadraBean> standings, String competition, String area, String emblem, String year, int currentMatchday, String  startDate, String  endDate) {
        this.standings = standings;
        this.competition = competition;
        this.area = area;
        this.emblem = emblem;
        this.year = year;
        this.currentMatchday = currentMatchday;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public standingsBean() {
    }

    public ArrayList<SquadraBean> getStandings() {
        return standings;
    }

    public void setStandings(ArrayList<SquadraBean> standings) {
        this.standings = standings;
    }

    public String getCompetition() {
        return competition;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getCurrentMatchday() {
        return currentMatchday;
    }

    public void setCurrentMatchday(int currentMatchday) {
        this.currentMatchday = currentMatchday;
    }

    public String  getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String  getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
