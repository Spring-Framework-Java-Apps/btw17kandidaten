package org.woehlke.btw17.kandidaten.oodm.graph.model.btw17;

import lombok.Getter;
import lombok.Setter;
import org.neo4j.ogm.annotation.*;
import org.woehlke.btw17.kandidaten.oodm.graph.model.commons.GraphDomainObject;
import org.woehlke.btw17.kandidaten.oodm.graph.model.enums.BundeslandEnum;

@Setter
@Getter
@NodeEntity
public class Btw17Wahlkreis implements GraphDomainObject {

    @Id
    @GeneratedValue
    private Long id;


    @Index(unique=true)
    @Property(name = "wahlkreis_nummer")
    private Long wahlkreisNummer;

    @Index
    @Property(name = "wahlkreis_name")
    private String wahlkreisName;

    @Index
    @Property(name = "bundesland_nummer")
    private Long bundeslandNummer;

    @Index
    @Property(name = "bundesland_name")
    private String bundeslandName;

    @Property(name = "bundesland_kurz")
    private BundeslandEnum bundeslandEnumKurz;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return wahlkreisName+" ( "+wahlkreisNummer+" ) in "+bundeslandName;
    }

    @Override
    public String getUniqueId() {
        return this.wahlkreisNummer + ":"+wahlkreisName+":"+ bundeslandEnumKurz;
    }

    public Btw17Wahlkreis() {
    }
}
