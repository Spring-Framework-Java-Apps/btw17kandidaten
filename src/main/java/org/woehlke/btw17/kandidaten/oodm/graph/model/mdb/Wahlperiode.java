package org.woehlke.btw17.kandidaten.oodm.graph.model.mdb;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.Mandatsart;
import org.woehlke.btw17.kandidaten.oodm.graph.model.kandidaten.ListeParteiBundesland;
import org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen.Institution;
import org.woehlke.btw17.kandidaten.oodm.all.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Wahlkreis;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.JOB;
import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.LOCATION;
import static org.woehlke.btw17.kandidaten.oodm.graph.model.commons.RelationshipType.WAHL;


@Setter
@Getter
@NodeEntity
public class Wahlperiode implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Index(unique = true)
    @Property(name = "wp")
    private Long wahlperiode;

    @Property(name = "mdbwpvon")
    private LocalDate mdbWahlperiodeVon;

    @Property(name = "mdbwpbis")
    private LocalDate mdbWahlperiodeBis;

    @Relationship(type=WAHL)
    private ListeParteiBundesland listeParteiBundesland = new ListeParteiBundesland();

    @Property(name = "mandatsart")
    private Mandatsart mandatsart;

    @Relationship(type=LOCATION)
    private Wahlkreis wahlkreis= new Wahlkreis();

    @Relationship(type=JOB)
    private List<Institution> institution = new ArrayList<Institution>();

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
