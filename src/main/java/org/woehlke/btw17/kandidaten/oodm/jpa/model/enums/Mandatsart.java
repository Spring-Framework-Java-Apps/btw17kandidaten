package org.woehlke.btw17.kandidaten.oodm.jpa.model.enums;

public enum Mandatsart {

    VOLKSKAMMER("Volkskammer"),
    DIREKTWAHL("Direktwahl"),
    LANDESLISTE("Landesliste");

    private String description;

    Mandatsart(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
