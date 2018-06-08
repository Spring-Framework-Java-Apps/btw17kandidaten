package org.woehlke.btw17.kandidaten.oodm.graph.model.geographie;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;



@Setter
@Getter
@NodeEntity
public class Adresse implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;

    @Index
    @Property(name="strasse")
    private String strasse;

    @Index
    @Property(name="hausnummer")
    private String hausnummer;

    @Index
    @Property(name="plz")
    private String plz;

    @Index
    @Property(name="ort")
    private String ort;

    @Property(name="nation")
    private String nation;

    @Property(name="bundesland")
    private String bundesland;

    //@Relationship(type = LOCATION)
    //private Bundesland bundesland = new Bundesland();

    //@Relationship(type = LOCATION)
    //private Nation nation = new Nation();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return plz+" "+ort;
    }

    @Override
    public String getUniqueId() {
        return plz+" "+ort+" "+id;
    }

    public Adresse() {
    }
}
