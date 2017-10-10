package org.woehlke.btw17.kandidaten.oodm.model.enums;

public enum BundeslandEnum {

    SL("Saarland"),
    HB("Hansestadt Bremen"),
    NI("Niedersachsen"),
    BB("Brandenburg"),
    HH("Hansestadt Hamburg"),
    SH("Schleswig-Holstein"),
    BE("Berlin"),
    RP("Rheinland-Pfalz"),
    SN("Sachsen"),
    BW("Baden-Württemberg"),
    MV("Mecklenburg-Vorpommern"),
    BY("Bayern"),
    NW("Nordrhein-Westfalen"),
    HE("Hessen"),
    TH("Thüringen"),
    ST("Sachsen-Anhalt");

    private String bundeslandName;

    BundeslandEnum(String bundeslandName){
        this.bundeslandName=bundeslandName;
    }

    public String getBundeslandName() {
        return bundeslandName;
    }
}
