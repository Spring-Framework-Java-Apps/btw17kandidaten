package org.woehlke.btw17.kandidaten.configuration;

public enum PageSymbol {

    BERUF("<i class=\"fa fa-cubes\" aria-hidden=\"true\"></i>"),
    BERUFSGRUPPE("<i class=\"fa fa-graduation-cap\" aria-hidden=\"true\"></i>"),
    BUNDESLAND("<i class=\"fa fa-puzzle-piece\" aria-hidden=\"true\"></i>"),
    BUNDESTAG("<i class=\"fa fa-university\" aria-hidden=\"true\"></i>"),
    GEBURTSORT("<i class=\"fa fa-map-marker\" aria-hidden=\"true\"></i>"),
    IMPRESSUM("<i class=\"fa fa-info-circle\" aria-hidden=\"true\"></i>"),
    SUCHE("<i class=\"fa fa-search\" aria-hidden=\"true\"></i>"),
    KANDIDAT("<i class=\"fa fa-user-circle\" aria-hidden=\"true\"></i>"),
    LANDESLISTE("<i class=\"fa fa-list-alt\" aria-hidden=\"true\"></i>"),
    PARTEI("<i class=\"fa fa-empire\" aria-hidden=\"true\"></i>"),
    WAHLKREIS("<i class=\"fa fa-map-o\" aria-hidden=\"true\"></i>"),
    WOHNORT("<i class=\"fa fa-map-marker\" aria-hidden=\"true\"></i>"),
    MANN("<i class=\"fa fa-mars\" aria-hidden=\"true\"></i>"),
    FRAU("<i class=\"fa fa-venus\" aria-hidden=\"true\"></i>"),
    TWITTER("<i class=\"fa fa-twitter-square\" aria-hidden=\"true\"></i>"),
    SOUNDCLOUD("<i class=\"fa fa-soundcloud\" aria-hidden=\"true\"></i>"),
    YOUTUBE("<i class=\"fa fa-youtube\" aria-hidden=\"true\"></i>"),
    FACEBOOK("<i class=\"fa fa-facebook-square\" aria-hidden=\"true\"></i>"),
    WEBSEITE("<i class=\"fa fa-link\" aria-hidden=\"true\"></i>"),
    WIKIPEDIA("<i class=\"fa fa-wikipedia-w\" aria-hidden=\"true\"></i>"),
    STARTSEITE("<i class=\"fa fa-play-circle\" aria-hidden=\"true\"></i>"),
    GEBURTSJAHR("<i class=\"fa fa-id-card\" aria-hidden=\"true\"></i>"),
    MDB("<i class=\"fa fa-university\" aria-hidden=\"true\"></i>"),
    ABGEORDNETENWATCH("<i class=\"fa fa-eye\" aria-hidden=\"true\"></i>"),
    LOBBYPEDIA("<i class=\"fa fa-balance-scale\" aria-hidden=\"true\"></i>"),
    LOBBYCONTROL("<i class=\"fa fa-balance-scale\" aria-hidden=\"true\"></i>"),
    TRANSPARENCY("<i class=\"fa fa-newspaper-o\" aria-hidden=\"true\"></i>"),
    BUNDESZENTRALE_POLITISCHE_BILDUNG("<i class=\"fa fa-clipboard\" aria-hidden=\"true\"></i>"),
    EXCEPTION("<i class=\"fa fa-bolt\" aria-hidden=\"true\"></i>"),
    LOGIN("<i class=\"fa fa-sign-in\" aria-hidden=\"true\"></i>"),
    FUNKTION("<i class=\"fa fa-superpowers\" aria-hidden=\"true\"></i>"),
    AUSSCHUSS("<i class=\"fa fa-users\" aria-hidden=\"true\"></i>"),
    MINISTERIUM("<i class=\"fa fa-home\" aria-hidden=\"true\"></i>"),
    FRAKTION("<i class=\"fa A\" aria-hidden=\"true\"></i>"),
    DATENSCHUTZ("<i class=\"fa fa-database\" aria-hidden=\"true\"></i>"),
    FOTO_URL("<i class=\"fa fa-picture-o\" aria-hidden=\"true\"></i>"),
    GOOGLE_PLUS("<i class=\"fa fa-google-plus-official\" aria-hidden=\"true\"></i>"),
    GOOGLE_SEARCH("<i class=\"fa fa-google\" aria-hidden=\"true\"></i>"),
    BING_SEARCH("<i class=\"fa fa-windows\" aria-hidden=\"true\"></i>"),
    NETZPOLITIK_ORG("<i class=\"fa fa-newspaper-o\" aria-hidden=\"true\"></i>"),
    INSTAGRAM("<i class=\"fa fa-google-plus-official\" aria-hidden=\"true\"></i>"),
    FLICKR("<i class=\"fa fa-google-plus-official\" aria-hidden=\"true\"></i>"),
    VIMEO("<i class=\"fa fa-vimeo-square\" aria-hidden=\"true\"></i>"),
    XING("<i class=\"fa fa-xing-square\" aria-hidden=\"true\"></i>"),
    LINKED_IN("<i class=\"fa fa-linkedin-square\" aria-hidden=\"true\"></i>"),
    STACKOVERFLOW("<i class=\"fa fa-stack-overflow\" aria-hidden=\"true\"></i>"),
    GITHUB("<i class=\"fa fa-github\" aria-hidden=\"true\"></i>"),
    REPORT_OVERVIEW("<i class=\"fa fa-play-circle\" aria-hidden=\"true\"></i>"),
    REPORT_MDB("<i class=\"fa fa-play-circle\" aria-hidden=\"true\"></i>"),
    REPORT_KANDIDAT("<i class=\"fa fa-play-circle\" aria-hidden=\"true\"></i>"),
    REPORT_DATA("<i class=\"fa fa-database\" aria-hidden=\"true\"></i>");

    private String symbolHtml;

    PageSymbol(String symbolHtml){
        this.symbolHtml = symbolHtml;
    }

    public String getSymbolHtml() {
        return symbolHtml;
    }
}
