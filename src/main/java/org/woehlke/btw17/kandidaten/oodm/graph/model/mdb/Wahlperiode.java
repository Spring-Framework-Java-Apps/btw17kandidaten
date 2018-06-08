package org.woehlke.btw17.kandidaten.oodm.graph.model.mdb;

import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObjectImpl;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.Mandatsart;
import org.woehlke.btw17.kandidaten.oodm.graph.model.organisationen.Institution;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.geographie.Wahlkreis;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Wahlperiode extends GraphDomainObjectImpl implements GraphDomainObject {

    @Index(unique = true)
    @Property(name = "wp")
    private Long wahlperiode;

    @Property(name = "mdbwpvon")
    private LocalDate mdbWahlperiodeVon;

    @Property(name = "mdbwpbis")
    private LocalDate mdbWahlperiodeBis;

    //@Relationship(type=WAHL)
    //private ListeParteiBundesland listeParteiBundesland = new ListeParteiBundesland();

    @Property(name = "mandatsart")
    private Mandatsart mandatsart;

    @Relationship(type=LOCATION)
    private Wahlkreis wahlkreis;// = new Wahlkreis();

    @Relationship(type=JOB)
    private Set<Institution> institution = new HashSet<>();

    @Override
    public String getName() {
        return wahlperiode.toString();
    }

    @Override
    public String getUniqueId() {
        return wahlperiode.toString();
    }

    public Wahlperiode() {
    }

    public Long getWahlperiode() {
        return wahlperiode;
    }

    public void setWahlperiode(Long wahlperiode) {
        this.wahlperiode = wahlperiode;
    }

    public LocalDate getMdbWahlperiodeVon() {
        return mdbWahlperiodeVon;
    }

    public void setMdbWahlperiodeVon(LocalDate mdbWahlperiodeVon) {
        this.mdbWahlperiodeVon = mdbWahlperiodeVon;
    }

    public LocalDate getMdbWahlperiodeBis() {
        return mdbWahlperiodeBis;
    }

    public void setMdbWahlperiodeBis(LocalDate mdbWahlperiodeBis) {
        this.mdbWahlperiodeBis = mdbWahlperiodeBis;
    }

    public Mandatsart getMandatsart() {
        return mandatsart;
    }

    public void setMandatsart(Mandatsart mandatsart) {
        this.mandatsart = mandatsart;
    }

    public Wahlkreis getWahlkreis() {
        return wahlkreis;
    }

    public void setWahlkreis(Wahlkreis wahlkreis) {
        this.wahlkreis = wahlkreis;
    }

    public Set<Institution> getInstitution() {
        return institution;
    }

    public void setInstitution(Set<Institution> institution) {
        this.institution = institution;
    }
}
