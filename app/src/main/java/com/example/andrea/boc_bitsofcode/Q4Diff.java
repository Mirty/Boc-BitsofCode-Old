package com.example.andrea.boc_bitsofcode;

/**
 * Created by federica on 14/02/17.
 */

public class Q4Diff {
    public String quesito,fun;
    public int fcond, scond, thcond;

    public Q4Diff (String quesito, String fun, int fcond, int scond, int thcond){
        this.scond = scond;
        this.fcond = fcond;
        this.thcond = thcond;
        this.quesito = quesito;
        this.fun = fun;
    }

    String getQuesito(){
        return quesito;
    }

    int getFcond(){ return fcond;}

    int getScond() {return scond;}

    int getThcond(){ return thcond;}

    String getFun(){
        return fun;
    }
}
