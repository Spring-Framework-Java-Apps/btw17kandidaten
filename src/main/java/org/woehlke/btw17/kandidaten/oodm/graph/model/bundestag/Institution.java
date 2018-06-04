package org.woehlke.btw17.kandidaten.oodm.graph.model.bundestag;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.InstitutionArt;

import java.time.LocalDate;

@Setter
@Getter
@NodeEntity
public class Institution implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    //@Enumerated(EnumType.STRING)
    @Property(name = "insartlang")
    private InstitutionArt institutionArtLang;

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


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return institutionArtLang.name();
    }

    @Override
    public String getUniqueId() {
        return institutionArtLang.name()+" "+id;
    }
}
