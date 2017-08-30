package org.woehlke.btw17.kandidaten.configuration;

public enum PageSymbol {

    BERUF("<i class=\"fa fa-cubes\" aria-hidden=\"true\"></i>"),
    BERUFSGRUPPE("<i class=\"fa fa-graduation-cap\" aria-hidden=\"true\"></i>"),
    BUNDESLAND("<i class=\"fa fa-puzzle-piece\" aria-hidden=\"true\"></i>"),
    GEBURTSORT("<i class=\"fa fa-map-marker\" aria-hidden=\"true\"></i>"),
    IMPRESSUM("<i class=\"fa fa-info-circle\" aria-hidden=\"true\"></i>"),
    SUCHE("<i class=\"fa fa-search\" aria-hidden=\"true\"></i>"),
    KANDIDAT("<i class=\"fa fa-user-circle\" aria-hidden=\"true\"></i>"),
    LISTE_PARTEI("<i class=\"fa fa-list-alt\" aria-hidden=\"true\"></i>"),
    PARTEI("<i class=\"fa fa-users\" aria-hidden=\"true\"></i>"),
    WAHLKREIS("<i class=\"fa fa-map-o\" aria-hidden=\"true\"></i>"),
    WOHNORT("<i class=\"fa fa-map-marker\" aria-hidden=\"true\"></i>"),
    MANN("<i class=\"fa fa-mars\" aria-hidden=\"true\"></i>"),
    FRAU("<i class=\"fa fa-venus\" aria-hidden=\"true\"></i>"),
    TWITTER("<i class=\"fa fa-twitter-square\" aria-hidden=\"true\"></i>"),
    YOUTUBE("<i class=\"fa fa-youtube\" aria-hidden=\"true\"></i>"),
    FACEBOOK("<i class=\"fa fa-facebook-square\" aria-hidden=\"true\"></i>"),
    WEBSEITE("<i class=\"fa fa-cloud\" aria-hidden=\"true\"></i>"),
    STARTSEITE("<i class=\"fa fa-play-circle\" aria-hidden=\"true\"></i>"),
    GEBURTSJAHR("<i class=\"fa fa-id-card\" aria-hidden=\"true\"></i>"),
    MDB("<i class=\"fa fa-university\" aria-hidden=\"true\"></i>"),
    EXCEPTION("<i class=\"fa fa-bolt\" aria-hidden=\"true\"></i>"),
    LOGIN("<i class=\"fa fa-sign-in\" aria-hidden=\"true\"></i>");

    private String symbolHtml;

    PageSymbol(String symbolHtml){
        this.symbolHtml = symbolHtml;
    }

    public String getSymbolHtml() {
        return symbolHtml;
    }
}
