package org.woehlke.btw17.kandidaten.frontend.model.enums;

public enum JumbotronImage {

    REICHSTAG_01("jumbotron hidden-xs hidden-sm tw-jumbotron-header01"),
    REICHSTAG_02("jumbotron hidden-xs hidden-sm tw-jumbotron-header02"),
    REICHSTAG_03("jumbotron hidden-xs hidden-sm tw-jumbotron-header03"),
    REICHSTAG_04("jumbotron hidden-xs hidden-sm tw-jumbotron-header04"),
    REICHSTAG_05("jumbotron hidden-xs hidden-sm tw-jumbotron-header05"),
    REICHSTAG_INNEN_01("jumbotron hidden-xs hidden-sm tw-jumbotron-header06"),
    REICHSTAG_INNEN_02("jumbotron hidden-xs hidden-sm tw-jumbotron-header07"),
    REICHSTAG_INNEN_HOCHKANT("jumbotron hidden-xs hidden-sm tw-jumbotron-header08"),
    WAHLZETTEL_BRIEFWAHL("jumbotron hidden-xs hidden-sm tw-jumbotron-header09");

    private String css;

    JumbotronImage(String css){
        this.css = css;
    }

    public String getCss() {
        return css;
    }
}
