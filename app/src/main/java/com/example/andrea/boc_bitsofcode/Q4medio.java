package com.example.andrea.boc_bitsofcode;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by federica on 17/01/17.
 */

public class Q4medio{

    public int fcond, scond, thcond, res;
    public String quesito, fun;

    public Q4medio (String quesito,String fun, int fcond, int scond, int thcond, int res){
        this.fcond = fcond;
        this.fun = fun;
        this.quesito = quesito;
        this.scond = scond;
        this.thcond = thcond;
        this.res = res;
    }

    String getQuesito(){
        return quesito;
    }

    int getFcond(){ return fcond;}
    String getFun(){ return fun;}
    int getscond(){ return scond;}
    int getthcond(){ return thcond;}
    int getres(){ return res;}
}