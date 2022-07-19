package com.example.dbsystelchallenge.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByNames;
import com.opencsv.bean.CsvIgnore;

/**
 * “Betriebsstellen” der Deutschen Bahn
 */
public class Betriebsstelle {

    /**
     * Primary location code: Eindeutige Nr. innerhalb Europa, z.B. DE 13273
     */
    @CsvBindByNames({
            @CsvBindByName(column = "PLC", profiles = "newFormat"),
            @CsvBindByName(column = "Primary location code", profiles = "oldFormat")
    })
    private String plc;

    /**
     * Abkürzung entsprechend Richtlinie 100.0001, die sich aus Ort und Art zusammensetzt
     */
    @CsvBindByNames({
            @CsvBindByName(column = "RL100-Code", profiles = "newFormat"),
            @CsvBindByName(column = "Abk", profiles = "oldFormat")
    })
    private String rl100Code;

    /**
     * Langname, z.B. Frankfurt (Main) Galluswarte
     */
    @CsvBindByNames({
            @CsvBindByName(column = "RL100-Langname", profiles = "newFormat"),
            @CsvBindByName(column = "Name", profiles = "oldFormat")
    })
    private String rl100NameLong;

    /**
     * Kurzname, z.B. Ffm Galluswarte
     */
    @CsvBindByNames({
            @CsvBindByName(column = "RL100-Kurzname", profiles = "newFormat"),
            @CsvBindByName(column = "Kurzname", profiles = "oldFormat")
    })
    private String rl100NameShort;

    /**
     * Zur Abk. gehörende Bahnstellenarten, in kurz z.B. MUSE
     */
    @CsvIgnore(profiles = "oldFormat")
    @CsvBindByName(column = "Typ Kurz")
    private String typeShort;

    /**
     * Zur Abk. gehörende Bahnstellenarten, in lang z.B. Museum
     */
    @CsvBindByNames({
            @CsvBindByName(column = "Typ Lang", profiles = "newFormat"),
            @CsvBindByName(column = "Typ", profiles = "oldFormat")
    })
    private String typeLong;

    /**
     * Betriebszustand
     */
    @CsvBindByNames({
            @CsvBindByName(column = "Betriebszustand", profiles = "newFormat"),
            @CsvBindByName(column = "Betr-Zust", profiles = "oldFormat")
    })
    private String operatingCondition;

    /**
     * gültig von im Format YYYYMMDD, z.B. 20081214
     */
    @CsvBindByNames({
            @CsvBindByName(column = "Datum ab", profiles = "newFormat"),
            @CsvBindByName(column = "gültig von", profiles = "oldFormat")
    })
    private String dateFrom;

    /**
     * gültig bis im Format YYYYMMDD. Bleibt frei, wenn keine Begrenzung vorliegt.
     */
    @CsvBindByNames({
            @CsvBindByName(column = "Datum bis", profiles = "newFormat"),
            @CsvBindByName(column = "gültig bis", profiles = "oldFormat")
    })
    private String dateTo;

    /**
     * RB: Zuständiger Regionalbereich Netz, nur für Örtlichkeiten der DB Netz AG, z.B. 5
     */
    @CsvBindByNames({
            @CsvBindByName(column = "Niederlassung", profiles = "newFormat"),
            @CsvBindByName(column = "RB", profiles = "oldFormat")
    })
    private String location;

    /**
     * Regionalbereich z.B. Ost
     */
    @CsvIgnore(profiles = "oldFormat")
    @CsvBindByName(column = "Regionalbereich")
    private String region;

    /**
     * UIC RICS code, z.B. 0080
     */
    @CsvIgnore(profiles = "newFormat")
    @CsvBindByName(column = "UIC")
    private String uic;

    /**
     * Eindeutiger unveränderlicher Schlüssel für alle Infrastrukturstellen, z.B. 117044
     */
    @CsvIgnore(profiles = "newFormat")
    @CsvBindByName(column = "Netz-Key")
    private String netz_key;

    /**
     * Fahrplanrelevanz – dies ist eine im Fahrplan bestellbare Örtlichkeit
     * – im Ausland nur ausnahmsweise gekennzeichnet, z.B. J
     */
    @CsvIgnore(profiles = "newFormat")
    @CsvBindByName(column = "Fpl-rel")
    private String fahrplanRelevance;

    /**
     * Fahrplanbearbeitungsgrenze – im Ausland nur ausnahmsweise gekennzeichnet, z.B. N
     */
    @CsvIgnore(profiles = "newFormat")
    @CsvBindByName(column = "Fpl-Gr")
    private String fpBearbeitungsgrenze;


    @CsvIgnore(profiles = "oldFormat")
    @CsvBindByName(column = "Letzte Änderung")
    private String lastChange;

    //Getter and Setter

    public String getUic() {
        return uic;
    }

    public void setUic(String uic) {
        this.uic = uic;
    }

    public String getNetz_key() {
        return netz_key;
    }

    public void setNetz_key(String netz_key) {
        this.netz_key = netz_key;
    }

    public String getFahrplanRelevance() {
        return fahrplanRelevance;
    }

    public void setFahrplanRelevance(String fahrplanRelevance) {
        this.fahrplanRelevance = fahrplanRelevance;
    }

    public String getFpBearbeitungsgrenze() {
        return fpBearbeitungsgrenze;
    }

    public void setFpBearbeitungsgrenze(String fpBearbeitungsgrenze) {
        this.fpBearbeitungsgrenze = fpBearbeitungsgrenze;
    }

    public String getRl100Code() {
        return rl100Code;
    }

    public String getPlc() {
        return plc;
    }

    public void setPlc(String plc) {
        this.plc = plc;
    }

    public void setRl100Code(String rl100Code) {
        this.rl100Code = rl100Code;
    }

    public String getRl100NameLong() {
        return rl100NameLong;
    }

    public void setRl100NameLong(String rl100NameLong) {
        this.rl100NameLong = rl100NameLong;
    }

    public String getRl100NameShort() {
        return rl100NameShort;
    }

    public void setRl100NameShort(String rl100NameShort) {
        this.rl100NameShort = rl100NameShort;
    }

    public String getTypeShort() {
        return typeShort;
    }

    public void setTypeShort(String typeShort) {
        this.typeShort = typeShort;
    }

    public String getTypeLong() {
        return typeLong;
    }

    public void setTypeLong(String typeLong) {
        this.typeLong = typeLong;
    }

    public String getOperatingCondition() {
        return operatingCondition;
    }

    public void setOperatingCondition(String operatingCondition) {
        this.operatingCondition = operatingCondition;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLastChange() {
        return lastChange;
    }

    public void setLastChange(String lastChange) {
        this.lastChange = lastChange;
    }

}
