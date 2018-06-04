package org.woehlke.btw17.kandidaten.oodm.graph.model.mdb;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.bundestag.Institution;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.Mandatsart;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Wahlkreis;

import javax.validation.Valid;
import java.time.LocalDate;


@Setter
@Getter
@NodeEntity
public class Wahlperiode implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "wp")
    private Long wahlperiode;

    @Property(name = "mdbwpvon")
    private LocalDate mdbWahlperiodeVon;

    @Property(name = "mdbwpbis")
    private LocalDate mdbWahlperiodeBis;

    //@Enumerated(EnumType.STRING)
    @Property(name = "liste")
    private BundeslandEnum bundeslandLandesListe;

    //@Enumerated(EnumType.STRING)
    @Property(name = "mandatsart")
    private Mandatsart mandatsArt;

    @Relationship(type="heimat_wahlkreis", direction=Relationship.OUTGOING)
    //@ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    //@JoinColumn(name="fk_wahlkreis")
    private Wahlkreis wahlkreis;

    @Valid
    //@Embedded
    private Institution institution = new Institution();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return wahlperiode.toString();
    }

    @Override
    public String getUniqueId() {
        return wahlperiode.toString();
    }
}
