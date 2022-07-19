package com.example.dbsystelchallenge.dto;

public class BetriebsstelleDto {

    /**
     * Langname, z.B. Frankfurt (Main) Galluswarte
     */
    private String Name;

    /**
     * Kurzname, z.B. Ffm Galluswarte
     */
    private String Kurzname;

    /**
     * Zur Abk. gehörende Bahnstellenarten, in lang z.B. Museum
     */
    private String Typ;


    //Getter and Setter

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getKurzname() {
        return Kurzname;
    }

    public void setKurzname(String kurzname) {
        Kurzname = kurzname;
    }

    public String getTyp() {
        return Typ;
    }

    public void setTyp(String typ) {
        Typ = typ;
    }


}
