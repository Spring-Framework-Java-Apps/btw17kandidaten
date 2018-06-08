package org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.InstitutionArt;

import java.time.LocalDate;

@NodeEntity
public class Institution extends GraphDomainObjectImpl implements GraphDomainObject {


    //@Enumerated(EnumType.STRING)
    @Property(name = "insartlang")
    private InstitutionArt institutionArtLang;

    @Index(unique = true)
    @Property(name = "inslang")
    private String institutionLang;

    @Property(name = "mdbinsvon")
    private LocalDate mdbInstitutionVon;

    @Property(name = "mdbinsbis")
    private LocalDate mdbInstitutionBis;

    @Property(name = "fktlang")
    private String funktionLang;

    @Property(name = "fktinsvon")
    private LocalDate funktionInstitutionVon;

    @Property(name = "fktinsbis")
    private LocalDate funktionInstitutionBis;

    public Institution() {
    }

    public InstitutionArt getInstitutionArtLang() {
        return institutionArtLang;
    }

    public void setInstitutionArtLang(InstitutionArt institutionArtLang) {
        this.institutionArtLang = institutionArtLang;
    }

    public String getInstitutionLang() {
        return institutionLang;
    }

    public void setInstitutionLang(String institutionLang) {
        this.institutionLang = institutionLang;
    }

    public LocalDate getMdbInstitutionVon() {
        return mdbInstitutionVon;
    }

    public void setMdbInstitutionVon(LocalDate mdbInstitutionVon) {
        this.mdbInstitutionVon = mdbInstitutionVon;
    }

    public LocalDate getMdbInstitutionBis() {
        return mdbInstitutionBis;
    }

    public void setMdbInstitutionBis(LocalDate mdbInstitutionBis) {
        this.mdbInstitutionBis = mdbInstitutionBis;
    }

    public String getFunktionLang() {
        return funktionLang;
    }

    public void setFunktionLang(String funktionLang) {
        this.funktionLang = funktionLang;
    }

    public LocalDate getFunktionInstitutionVon() {
        return funktionInstitutionVon;
    }

    public void setFunktionInstitutionVon(LocalDate funktionInstitutionVon) {
        this.funktionInstitutionVon = funktionInstitutionVon;
    }

    public LocalDate getFunktionInstitutionBis() {
        return funktionInstitutionBis;
    }

    public void setFunktionInstitutionBis(LocalDate funktionInstitutionBis) {
        this.funktionInstitutionBis = funktionInstitutionBis;
    }
}
