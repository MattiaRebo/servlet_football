package model;

import java.util.ArrayList;
import java.util.Date;

public class standingsBean {

    ArrayList<SquadraBean> classifica;

    public standingsBean(ArrayList<SquadraBean> classifica) {
        this.classifica = classifica;
    }
    public ArrayList<SquadraBean> getClassifica() {
        return classifica;
    }
    public void setClassifica(ArrayList<SquadraBean> classifica) {
        this.classifica = classifica;
    }

}
