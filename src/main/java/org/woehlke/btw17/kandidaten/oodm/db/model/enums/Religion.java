package org.woehlke.btw17.kandidaten.oodm.db.model.enums;

public enum Religion {

    KONFESSIONSLOS("konfessionslos"),
    OHNE_ANGABEN("ohne Angaben"),
    NEUAPOSTOLISCH("neuapostolisch"),
    EVANGELISCH_REFORMIERT("evangelisch-reformiert"),
    EVANGELISCH("evangelisch"),
    EVANGELISCH_FREIKIRCHLICH("evangelisch-freikirchlich"),
    RELIGIONSLOS("religionslos"),
    EVANGELISCH_LUTHERISCH("evangelisch-lutherisch"),
    FREIRELIGIOES("freireligiös"),
    ISLAM("Islam"),
    ATHEISTIN("Atheistin"),
    HUMANISTISCH("humanistisch"),
    MUSLIMISCH("muslimisch"),
    PROTESTANTISCH("protestantisch"),
    ROEMISCH_KATHOLISCH("römisch-katholisch"),
    ATHEIST("Atheist"),
    KATHOLISCH("katholisch");

    private String description;

    Religion(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
