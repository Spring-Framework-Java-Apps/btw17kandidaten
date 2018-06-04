package org.woehlke.btw17.kandidaten.oodm.graph.model.enums;

/**
 * Institutionen im Bundestag
 */
public enum InstitutionArt {

    AUSSCHUSS("Ausschuss"),
    DEUTSCHER_BUNDESTAG("Deutscher Bundestag"),
    ARBEITSGRUPPE("Arbeitsgruppe"),
    SONSTIGES_GREMIUM("Sonstiges Gremium"),
    MINISTERIUM("Ministerium"),
    UNTERAUSSCHUSS("Unterausschuss"),
    UNTERSUCHUNGSAUSSCHUSS("Untersuchungsausschuss"),
    FRAKTION_GRUPPE("Fraktion/Gruppe");


    private String description;

    InstitutionArt(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
