package org.woehlke.btw17.kandidaten.oodm.graph.model;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.woehlke.btw17.kandidaten.oodm.db.model.Wahlkreis;
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.BundeslandEnum;
import org.woehlke.btw17.kandidaten.oodm.db.model.enums.Mandatsart;
import org.woehlke.btw17.kandidaten.oodm.db.model.parts.Institution;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;


@Setter
@Getter
@NodeEntity
public class Wahlperiode implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "wp")
    private Long wahlperiode;

    @Column(name = "mdbwpvon")
    private LocalDate mdbWahlperiodeVon;

    @Column(name = "mdbwpbis")
    private LocalDate mdbWahlperiodeBis;

    @Enumerated(EnumType.STRING)
    @Column(name = "liste")
    private BundeslandEnum bundeslandLandesListe;

    @Enumerated(EnumType.STRING)
    @Column(name = "mandatsart")
    private Mandatsart mandatsArt;

    @ManyToOne(fetch=FetchType.LAZY,cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="fk_wahlkreis")
    private Wahlkreis wahlkreis;

    @Valid
    @Embedded
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
